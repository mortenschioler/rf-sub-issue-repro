(ns rf-sub-issue-repro.view
  (:require
    [re-frame.core :as rf]))

(defn set-current-ID-0
  []
  [:button {:onClick #(rf/dispatch [:set-current-foo-id 0])}
   "Switch to 0"])

(defn set-current-ID-1
  []
  [:button {:onClick #(rf/dispatch [:set-current-foo-id 1])}
   "Switch to 1"])

(defn set-value-of-0-to-alpha
  []
  [:button {:onClick #(rf/dispatch [:set-foo 0 "Alpha"])}
   "Set value of 0 to Alpha"])

(defn set-value-of-0-to-beta
  []
  [:button {:onClick #(rf/dispatch [:set-foo 0 "Beta"])}
   "Set value of 0 to Beta"
   ])

(defn set-value-of-1-to-gamma
  []
  [:button {:onClick #(rf/dispatch [:set-foo 1 "Gamma"])}
   "Set value of 1 to Gamma"
   ])

(defn set-value-of-1-to-epsilon
  []
  [:button {:onClick #(rf/dispatch [:set-foo 1 "Epsilon"])}
   "Set value of 1 to Epsilon"])

(defn buttons
  []
  [:<>
   [set-current-ID-0]
   [set-current-ID-1]
   [set-value-of-0-to-alpha]
   [set-value-of-0-to-beta]
   [set-value-of-1-to-gamma]
   [set-value-of-1-to-epsilon]])


(defn render-foo
  [id]
  (println "rendered render-foo.")
  [:div
   (str "Foo " id " has the value [" @(rf/subscribe [:get-foo id]) "].")])

(defn allegedly-bad-component
  []
  (let [id (rf/subscribe [:get-current-foo-id])]
    (println "rendered allegedly-bad-component. id was [" @id "].")
    [:div
     [:div (str "The current foo has ID [" @id "].")]
     [render-foo @id]]))

(defn page
  []
  [:div {:style {:fontSize "42px"}}
   [allegedly-bad-component]
   [buttons]])

