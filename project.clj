(defproject circleci/congomongo
  "2.2.3.1" ;; the upstream version is 2.2.3
  :description "Clojure-friendly API for MongoDB"
  :url "https://github.com/congomongo/congomongo"
  :mailing-list {:name "CongoMongo mailing list"
                 :archive "https://groups.google.com/forum/?fromgroups#!forum/congomongo-dev"
                 :post "congomongo-dev@googlegroups.com"}
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"
            :distribution :repo}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/data.json "0.2.7"]
                 [org.mongodb/mongodb-driver-legacy "4.3.1"]
                 [org.clojure/clojure "1.10.1" :scope "provided"]]
  :repositories [["releases" {:url "https://repo.clojars.org"
                              :sign-releases false
                              :username :env/clojars_username
                              :password :env/clojars_token}]
                 ["snapshots" {:url "https://repo.clojars.org"
                               :username :env/clojars_username
                               :password :env/clojars_token}]]
  ;; if a :dev profile is added, remember to update :aliases below to
  ;; use it in each with-profile group!
  :profiles {:1.9 {:dependencies [[org.clojure/clojure "1.9.0"]]}
             :1.10 {:dependencies [[org.clojure/clojure "1.10.1"]]}}
  :aliases {"test-all" ["with-profile" "default,1.9:default,1.10" "test"]})
