(ns ^:figwheel-hooks rf-sub-issue-repro.app
  (:require
    [goog.dom :as dom]
    [re-frame.core :as rf]
    [reagent.dom :as rdom]
    [rf-sub-issue-repro.view :as view]))

(enable-console-print!)

(rf/reg-sub :get-foo
  (fn [db [_ id]]
    (get-in db [:foo id])))

(rf/reg-event-db :set-foo
  (fn [db [_ id x]]
    (assoc-in db [:foo id] x)))

(rf/reg-sub :get-current-foo-id
  :-> :foo-key)

(rf/reg-event-db :set-current-foo-id
  (fn [db [_ id]]
    (assoc db :foo-key id)))

(defn mount!
  []
  (rdom/render [#'view/page] (dom/getElement "app")))

(defn init!
  []
  (rf/dispatch-sync [:set-current-foo-id 0])
  (rf/dispatch-sync [:set-foo 0 "Alpha"])
  (mount!))

(defonce ^:export app (init!))

(defn ^:after-load refresh!
  []
  (println "Refreshed")
  (rf/clear-subscription-cache!)
  (mount!))
