(ns spc-as-my-leader.views
  (:require
   [clojure.string :as string]
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

(defn title-slide []
  [:div.card-content
   [:div.columns>div.column>div.hero.is-primary>div.hero-body>div.container
    [:h1.title.is-1 "SPC as my leader"]
    [:h2.subtitle.is-3 "programming Clojure with Spacemacs"]]
   [:div.columns.is-mobile
    [:div.column.is-4.is-offset-2>figure.image.is-256x256>img
     {:src "/img/clj-logo.svg"}]
    [:div.column.is-4>figure.image.is-256x256>img
     {:src "/img/spacemacs-logo.svg"}]]
   [:div.columns>div.column>i.is-size-5 "Erwin Rooijakkers"]])

(defn intro-slide []
  [:div.card-content
   [:h1.title "INTRO"]
   [:p "My experience. Cannot do deep dive. Just glimpse."]
   [:p "Why clojure? data, fp, lisp, but also this editor. cannot work if i cannot use spcmacs "]
   [:p "Why Vim?"]
   [:p
    [:pre
     (string/join
      "\n"
      ["vi is [[13~^[[15~^[[15~^[[19~^[[18~^ a "
       "muk[^[[29~^[[34~^[[26~^[[32~^ch better editor than this emacs. I know "
       "I^[[14~'ll get flamed for this but the truth has to be "
       "said. ^[[D^[[D^[[D^[[D ^[[D^[^[[D^[[D^[[B^ "
       "exit ^X^C quit :x :wq dang it :w:w:w :x ^C^C^Z^D"])]
    [:i "— Jesper Lauridsen from alt.religion.emacs"]]
   [:p "ci .)"]
   [:p "SPC"]
   [:p "rrrrr"]
   [:p "Evil as my leader"]
   [:div.content
    [:li "Spacemacs"
     [:ul
      [:li "batteries included"]
      [:li "layers - ,"]
      [:li "logical bindings, self discoverable"]]]
    [:li "Clojure(Script)"
     [:ul
      [:li "Lisp on the JVM and JavaScript runtime, immutable data structures"]]]]])

(defn evil-slide []
  [:li "EVIL mode"
   [:ol
    [:li "home row"]
    [:li "modal editing"]
    [:li "VERBS CHANGE INSIDE \""]
    [:li "select previous region"]
    [:li "jump to other side"]
    [:li "break up with mouse"]
    [:li "remap Caps Lock to ESC"]
    [:li "speed up key repeat, or not"]
    [:li "there's always a faster way"]
    [:li "can it do? yes - also for spacemacs"
     [:p "Example: multiple cursors"]]]])

(defn cider-slide []
  [:li "Cider"
   [:ol
    [:li "Documentation"]
    [:li "REPL"]
    [:li "source"]
    [:li "doc"]
    [:li "debugging"]
    [:li "enlighten mode"]
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
    [:li "threading macros"
     (str (reduce + (mapv inc [1 2 3])))]
    [:li "Introduce let, convolute, move to let"]]])

(defn conclusion-slide []
  [:li "how to get started?"
   [:ul
    [:li "vimtutor"]
    [:li "start using it at work"]]])

(def slide-deck
  [[title-slide]
   [intro-slide]
   [cider-slide]
   [evil-slide]
   [structural-editing-slide]
   [clj-refactor-slide]
   [conclusion-slide]])

;; v = f(s), view v is function f of application state s
(defn view [state]
  [:section
   [:section#main-panel.section>div.card
    (get slide-deck (:page state))]
   [:footer.footer
    [:nav.pagination
     [:button.button.pagination-previous
      {:on-click previous-page!} "previous"]
     [:button.button.pagination-next
      {:on-click next-page!} "next"]
     [:button.button {:on-click request-full-screen}
      "full screen"]]]])

(defn main-panel []
  [view @app-state])
