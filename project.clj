(defproject hue-web-app "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
		 [clj-http "3.6.1"]
                 [cheshire "5.7.1"]
                 [org.clojure/core.async "0.2.395"]
                 [ring "1.6.0"]
                 [compojure "1.6.0"]
                 [ring/ring-defaults "0.3.0"]
                 [ring-middleware-format "0.7.0"]
                 [metosin/ring-http-response "0.6.5"]
                 [selmer "1.0.2"]
		 [toledohue "0.1.1"]
                 [lib-noir "0.9.9"]]
  :main hue-web-app.core
  :aot [hue-web-app.core])
