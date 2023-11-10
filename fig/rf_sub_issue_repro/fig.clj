(ns rf-sub-issue-repro.fig
  (:require
    [nrepl.cmdline]
    [figwheel.main.api :as fig]))


(defn nrepl
  [_]
  (future (nrepl.cmdline/-main "--middleware" "[cider.piggieback/wrap-cljs-repl]"
                               "--headless"))               ; thanks to https://github.com/bhauman/figwheel-main/issues/112#issuecomment-626618334
  (fig/start {:id "app"
              :config {:mode :serve; no repl to encourage nrepl clients
                       :watch-dirs ["src"]
                       :cljs-devtools true}
              :options {:main 'rf-sub-issue-repro.app
                        #_#_:preloads ['rf-sub-issue-repro.devtools]}}))
