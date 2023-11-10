(ns rf-sub-issue-repro.devtools
  (:require
    [devtools.core :as devtools]))


; Squelch an annoying "some custom formatters were not enabled" warning,
; because it is A LIE. The formatters are enabled, but the detection does
; not work correctly.
(devtools/set-pref! :dont-detect-custom-formatters true)
