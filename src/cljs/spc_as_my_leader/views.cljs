(ns spc-as-my-leader.views
  (:require
   [reagent.core :as r]))

(defonce app-state
  (r/atom {:page 0}))

(defn main-panel []
  (fn []
    (let [page (:page @app-state)]
      [:div#main-panel
       [:ol "zaken" page
        [:li "INTRO"
         [:p "My experience. Cannot do deep dive. Just glimpse."]
         [:p "Why Vim?"]
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
            [:li "Lisp on the JVM and JavaScript runtime, immutable data structures"]]]]]
        [:li "EVIL mode"
         [:ol
          [:li "home row"]
          [:li "modal editing"]
          [:li "break up with mouse"]
          [:li "remap Caps Lock to ESC"]
          [:li "speed up key repeat, or not"]
          [:li "there's always a faster way"]
          [:li "can it do? yes - also for spacemacs"
           [:p "Example: multiple cursors"]]
          [:li "VERBS"]]]
        [:li "Cider"
         [:ol
          [:li "Documentation"]
          [:li "REPL"]
          [:li "source"]
          [:li "debugging"]]]
        [:li "Structural editing"
         [:ul
          [:li "slurp/barf emoticons"]
          [:li "transpose"]
          [:li "convolute"]]]
        [:li "clj-refactor"
         [:ul
          [:li "Add dependency"]
          [:li "Extract variable"]]]
        [:li "how to get started?"
         [:ul
          [:li "vimtutor"]
          [:li "start using it at work"]]]]
       [:button {:on-click #(.. js/document
                                (getElementById "main-panel")
                                requestFullscreen)}
        "full screen"]])))
