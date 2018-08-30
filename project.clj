(defproject circleci/congomongo "0.5.0-SNAPSHOT"

  :version-spec "0.5.~{:env/circle_build_num}"

  :description "Clojure-friendly API for MongoDB"
  :url "https://github.com/aboekhoff/congomongo"
  :mailing-list {:name "CongoMongo mailing list"
                 :archive "https://groups.google.com/forum/?fromgroups#!forum/congomongo-dev"
                 :post "congomongo-dev@googlegroups.com"}
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"
            :distribution :repo}
  :min-lein-version "2.0.0"

  :dependencies [[org.clojure/core.incubator "0.1.3"]
                 [org.clojure/data.json "0.2.4"]
                 [org.mongodb/mongo-java-driver "3.2.2"]
                 [org.clojure/clojure "1.7.0"]]

  ;; if a :dev profile is added, remember to update :aliases below to
  ;; use it in each with-profile group!
  :profiles {:1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0-alpha2"]]}
             :dev {:plugins [[lein-environ "1.1.0"]
                             [test2junit "1.2.2"]
                             [lein-cloverage "1.0.9"]]}}

  :repositories {"circle-s3"
                 {:url "s3p://circle-jars/releases"
                  :sign-releases false ;; TODO put a gpg key on CI
                  :username [:gpg :env/circle_jars_username ]
                  :passphrase [:gpg :env/circle_jars_password]
                  :snapshots false}

                 "circle-s3-snapshots"
                 {:url "s3p://circle-jars/snapshots"
                  :sign-releases false ;; TODO put a gpg key on CI
                  :username [:gpg :env/circle_jars_username]
                  :passphrase [:gpg :env/circle_jars_password]
                  :snapshots true}}

  :plugins [[circle/s3-wagon-private "1.2.2"]
            [circleci/lein-version-spec "0.0.5" :exclusions [org.clojure/clojure]]]

  :aliases {"test-all" ["with-profile" "default:1.3,default:1.4,default:1.5,default:1.6,default:1.8,default" "test"]})
