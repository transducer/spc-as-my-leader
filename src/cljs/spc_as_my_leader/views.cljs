(ns spc-as-my-leader.views
  (:require
   [clojure.string :as string]
   [reagent.core :as r]))

(defonce app-state
  (r/atom {:page-number 0}))

(defn previous-page! []
  (swap! app-state update :page-number dec))

(defn next-page! []
  (swap! app-state update :page-number inc))

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
    [:div.column.is-4.is-offset-2>figure.image>img
     {:src "/img/clj-logo.svg"}]
    [:div.column.is-4>figure.image>img
     {:src "/img/spacemacs-logo.svg"}]]
   [:div.columns>div.column>i.is-size-5 "Erwin Rooijakkers"]])

(defn background-slide-1 []
  [:div.card-content.content
   [:h1.title.is-1 "2015"]
   [:div.columns.is-centered.is-mobile
    [:div.column.is-11.is-offset-1
     [:a {:href "https://youtu.be/_NUO4JEtkDw" :target "_blank"}
      [:figure.image>img
       {:src "/img/learning-vim-in-a-week.png"}]]]]])

(defn vim-slide-1 []
  [:div.card-content
   [:h1.title.is-1 "Vim"]
   [:div.columns.is-mobile.is-centered
    [:div.column.is-6>figure.image.is>img
     {:src "/img/vim-logo.svg"}]]])

(defn vim-slide-2 []
  [:div.card-content
   [:h1.title.is-1 "Vim"]
   [:div.columns.is-mobile
    [:div.column.is-offset-1
     [:dl
      [:li "Home row"]
      [:li "Modal editing"]
      [:li "Can it do? Yes."]
      [:li "The Vim language"
       [:pre.is-size-5
        (string/join "\n"
                     ["ci)aaESC # change inside parens to aa"
                      ".        # perform previous command again"
                      "ds\"      # delete surrounding quotes"
                      "d5w      # delete five words"
                      "o        # open below / other side"
                      "gv       # reselect last selection"
                      "gi       # insert mode at last location"
                      "(...)"])]]]]]])

(defn vim-slide-3 []
  [:div.card-content
   [:h1.title.is-1 "Vim"]
   [:div.columns.is-mobile>div.column.content
    [:blockquote.blockquote.is-success.is-size-6
     (->> ["But as time went on, you struggled less and "
           "less. You aren’t sure when it happened, but Vim "
           "stopped being a hindrance. Instead, it become "
           "something greater than you had anticipated. It "
           "wasn’t a mere text editor with keyboard "
           "shortcuts anymore—it had become an extension "
           "of your body. Nay, an extension of your very "
           "essence as a programmer."]
          (interpose [:br]))
     [:br]
     [:br]
     [:a {:href "https://www.norfolkwinters.com/vim-creep/"}
      "Norfolk Winters - Vim Creep"]]]])

(defn background-slide-2 []
  [:div.card-content.content
   [:h1.title.is-1 "2016"]
   [:div.columns.is-centered.is-mobile
    [:div.column.is-11.is-offset-1
     [:a {:href "https://youtu.be/0m6hoOelZH8" :target "_blank"}
      [:figure.image>img
       {:src "/img/sicp.png"}]]]]])

(defn clojure-slide-1 []
  [:div.card-content
   [:h1.title.is-1 "Clojure"]
   [:div.columns.is-mobile
    [:div.column.is-6>figure.image>img
     {:src "/img/clj-logo.svg"}]
    [:div.column.is-5.is-offset-1
     [:dl
      [:li "Lisp"]
      [:li "On JVM and in browser"]
      [:li "Immutable data structures"]
      [:li "Data first"]]]]])

(defn clojure-slide-2 []
  [:div.card-content.content
   [:h1.title.is-1 "Emacs..."]
   [:div.columns.is-centered.is-mobile
    [:div.column.is-6
     [:a
      {:href
       "https://twitter.com/amperity/status/1068978794910777344"
       :target "_blank"}
      [:figure.image>img
       {:src "/img/commercial.png"}]]]]])

(defn spacemacs-slide []
  [:div.card-content
   [:h1.title.is-1 "Spacemacs"]
   [:div.columns.is-mobile
    [:div.column.is-5
     [:a {:href "https://github.com/syl20bnr/spacemacs"
          :target "_blank"}
      [:figure.image.is>img
       {:src "/img/spacemacs.png"}]]]
    [:div.column.is-6.is-offset-1
     [:dl
      [:li "Evil-mode"]
      [:li "Community configured"]
      [:li ".spacemacs"]
      [:li "Discoverable"]]]]])

(defn intro-slide []
  [:div.card-content
   [:h1.title "INTRO"]
   [:p "My experience. Cannot do deep dive. Just glimpse."]
   [:p "Why clojure? data, fp, lisp, but also this editor. cannot work if i cannot use spcmacs "]
   [:p "Why Vim?"]
   [:p.content
    [:blockquote.blockquote.is-success
     (interpose
      [:br]
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

(defn extras-slide []
  [:div
   "undo tree"
   "multiple-cursors"])

(defn conclusion-slide []
  [:li "how to get started?"
   [:ul
    [:li "vimtutor"]
    [:li "start using it at work"]]])

(def slide-deck
  [[title-slide]
   [background-slide-1]
   [vim-slide-1]
   [vim-slide-2]
   [vim-slide-3]
   [background-slide-2]
   [clojure-slide-1]
   [clojure-slide-2]
   [spacemacs-slide]
   [intro-slide]
   [cider-slide]
   [structural-editing-slide]
   [clj-refactor-slide]
   [extras-slide]
   [conclusion-slide]])

;; v = f(s), view v is function f of application state s
(defn view [state]
  [:div
   [:section#main-panel.section>div.card.is-size-2
    (get slide-deck (:page-number state))]
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
