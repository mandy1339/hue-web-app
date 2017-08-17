(ns hue-web-app.core
(:require [clj-http.client :as http]
            [clojure.data.json :as json]
            [clojure.java.io :as io]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.format :refer [wrap-restful-format]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults site-defaults]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.util.response :as response]        ;;from ring
            [ring.util.http-response :as response2]  ;;from metosin
            [compojure.core :refer :all]
            [compojure.route :as route]
            [selmer.parser :as selmer]	;;for html templating
            [noir.util.middleware :as middleware]
            [noir.session :as session]  ;;noir for redirect to work
            [clojure.core.async 
             :as a
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout poll! dropping-buffer sliding-buffer]])
  (:use [clojure.pprint])
  (:use [ring.adapter.jetty])
  (:use [toledohue.hue])
  (:gen-class))




(def user (get-user))  ;;caching user-name

;;SERIOUS WEBAPP ROUTES
;;-------------------------------------------------------------------------
(defroutes hue-app-routes

  ;;RESOURCES
  (route/resources "/")

  ;;HOME
  (GET "/" [] (session/put! :origin "/") (io/file "resources/public/testsite.html"))

  ;;ON/OFF
  (GET "/turn-off" [] (turn-group-off 3 user ) (response/redirect (session/get! :origin "/")))
  (GET "/turn-on" [] (turn-group-on 3 user) (response/redirect (session/get! :origin "/")))

  ;;COLORS
  (GET "/set-red" [] (hue-group 3 0 user) (response/redirect (session/get! :origin "/")))
  (GET "/set-yellow" [] (hue-group 3 12750 user) (response/redirect (session/get! :origin "/")))
  (GET "/set-green" [] (hue-group 3 25500 user) (response/redirect (session/get! :origin "/")))
  (GET "/set-blue" [] (hue-group 3 46920 user) (response/redirect (session/get! :origin "/")))
  (GET "/set-pink" [] (hue-group 3 56100 user) (response/redirect (session/get! :origin "/")))
  (GET "/set-white" [] (hue-group 3 32000 user) (response/redirect (session/get! :origin "/")))
  
  ;;CYCLES
  (GET "/cycle-30-sec" [] (cycle-group-30-secs 3 user) (response/redirect (session/get! :origin "/")))
  (GET "/cycle-60-sec" [] (cycle-group-1-min 3 user) (response/redirect (session/get! :origin "/")))
  (GET "/kill-cycle" [] (kill-cycle) (response/redirect (session/get! :origin "/")))
  
  ;;BRIGHTNESS
  (GET "/set-bri-0" [] (bri-group 3 0 user) (response/redirect (session/get! :origin "/")))
  (GET "/set-bri-25" [] (bri-group 3 63 user) (response/redirect (session/get! :origin "/")))
  (GET "/set-bri-50" [] (bri-group 3 127 user) (response/redirect (session/get! :origin "/")))
  (GET "/set-bri-75" [] (bri-group 3 190 user) (response/redirect (session/get! :origin "/")))
  (GET "/set-bri-100" [] (bri-group 3 255 user) (response/redirect (session/get! :origin "/")))

)


;;STARTING THE SERVER
;;--------------------------------------------------------------------------
(defn siteparams
  []
 )


(defn -main
  "I don't do a whole lot."
  [] 
  (run-jetty (-> #'hue-app-routes
                 wrap-reload
                 wrap-restful-format
                 wrap-params
                 session/wrap-noir-session
                 )
             {:port 5003
              :join? false}))

