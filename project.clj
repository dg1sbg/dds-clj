(defproject net.goenninger.dca.dds-clj "0.1.0-SNAPSHOT"
  :description "ONG DDS Transport Layer for Gönninger B&T's Distributed Computing Architecture DCA"
  :url "https://www.goenninger.net/dca/index.html"
  :license {:name "Proprietary License"
            :url "https://www.goenninger.net/dca/license.html"}
  :plugins [;;[lein-auto "1.1.3"]
            [com.livingsocial/lein-dependency-check "0.2.2"]
            [cider/cider-nrepl "0.16.0-SNAPSHOT"]
            ;;[lein-ancient "0.6.15-SNAPSHOT"]
            ]
  :dependencies
    [[cider/cider-nrepl "0.16.0-SNAPSHOT" :exclusions [org.clojure/tools.nrepl]]
     [clojure-complete "0.2.4" :exclusions [[org.clojure/clojure]]]
     [com.rti.ndds/nddsjavad "5.3.0"]
     [org.clojure/clojure "1.8.0"]
     [org.clojure/tools.nrepl "0.2.13" :exclusions [[org.clojure/clojure]]]
     [org.tcrawley/dynapath "0.2.5" :exclusions [[org.clojure/clojure]]]]
  :jvm-opts ["-Djava.library.path=/opt/dds/rti/connext_dds/macosx/rti_connext_dds-5.3.0/lib/x64Darwin16clang8.0/:./lib/"]
  ;;:main ^:skip-aot net.goenninger.dca.dds-clj.core
  :target-path "build/%s"
  :profiles {:uberjar {:aot :all}})
