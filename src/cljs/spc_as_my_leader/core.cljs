(ns spc-as-my-leader.core
  (:require
   [reagent.core :as reagent]
   [spc-as-my-leader.config :as config]
   [spc-as-my-leader.views :as views]))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (dev-setup)
  (views/load-keydown-listener)
  (mount-root))
