(ns spc-as-my-leader.views
  (:require
   [reagent.core :as r]))

(defonce app-state
  (r/atom {:page 0}))

(defn previous-page! []
  (swap! app-state update :page dec))

(defn next-page! []
  (swap! app-state update :page inc))

(defn handle-key-press! [key-code]
  (condp = key-code
    37 (previous-page!)
    39 (next-page!)
    :do-nothing))

(defn key-press-listener [e]
  (handle-key-press! (.-keyCode e)))

(defn load-keydown-listener! []
  (.. js/document
      (addEventListener "keydown" key-press-listener)))

(defn request-full-screen []
  (.. js/document
      (getElementById "main-panel")
      requestFullscreen))

(defn intro-slide []
  [:li "INTRO"
   [:p "My experience. Cannot do deep dive. Just glimpse."]
   [:p "Why Vim?"]
   [:p "ci .)"]
   [:p "SPC"]
   [:p "rrrrr"]
   [:p "Evil as my leader"]
   [:ul
    [:li "Spacemacs"
     [:ul
      [:li "batteries included"]
      [:li "layers - ,"]]]
    [:li "Clojure(Script)"
     [:ul
      [:li "Lisp on the JVM and JavaScript runtime, immutable data structures"]]]]])

(defn evil-slide []
  :li "EVIL mode"
  [:ol
   [:li "home row"]
   [:li "modal editing"]
   [:li "break up with mouse"]
   [:li "remap Caps Lock to ESC"]
   [:li "speed up key repeat, or not"]
   [:li "there's always a faster way"]
   [:li "can it do? yes - also for spacemacs"
    [:p "Example: multiple cursors"]]
   [:li "VERBS"]])

(defn cider-slide []
  [:li "Cider"
   [:ol
    [:li "Documentation"]
    [:li "REPL"]
    [:li "source"]
    [:li "debugging"]
    [:li "macro expansion"]]])

(defn structural-editing-slide []
  [:li "Structural editing"
   [:ul
    [:li "slurp/barf emoticons"]
    [:li "transpose"]
    [:li "convolute"]]])

(defn clj-refactor-slide []
  [:li "clj-refactor"
   [:ul
    [:li "Add dependency"]
    [:li "threading macros"]
    [:li "Introduce let, convolute, move to let"]]])

(defn conclusion-slide []
  [:li "how to get started?"
   [:ul
    [:li "vimtutor"]
    [:li "start using it at work"]]])

(def slide-deck
  [[intro-slide]
   [evil-slide]
   [cider-slide]
   [structural-editing-slide]
   [clj-refactor-slide]
   [conclusion-slide]])

(defn main-panel []
  (fn []
    (let [page (:page @app-state)]
      [:div#main-panel
       [:ol "zaken" page
        (get slide-deck page)]
       [:button {:on-click previous-page!} "previous"]
       [:button {:on-click next-page!} "next"]
       [:button {:on-click request-full-screen}
        "full screen"]])))
