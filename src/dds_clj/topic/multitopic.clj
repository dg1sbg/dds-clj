;;;; ==========================================================================
;;;;    D D S - C L J  - An RTI Connext DDS Java Wrapper
;;;; ==========================================================================
;;;;
;;;; Copyright (C) by Gönninger B&T UG (haftungsbeschränkt), Germany
;;;;
;;;; Use at own risk. No warranty. No liability. No nothing.
;;;; German law applies in all cases. Location of court is Stuttgart, Germany.
;;;;
;;;; ==========================================================================
;;;;
;;;;   WRAPPER FOR:  COM:RTI.DDS.TOPIC.MULTITOPIC
;;;;
;;;; --------------------------------------------------------------------------
;;;;
;;;;   OPEN ISSUES:
;;;;
;;;;   001 TODO: Documentation
;;;;
;;;; ==========================================================================

;;;; --------------------------------------------------------------------------
;;;;   NAMESPACE
;;;; --------------------------------------------------------------------------

(ns dds-clj.topic.contentfilteredtopic

  (:require [dds-clj.core.util :as core-util])

  (:import [com.rti.dds.infrastructure

            StringSeq
           ]

           [com.rti.dds.topic

            MultiTopic
           ]
           ))

;;;; --------------------------------------------------------------------------
;;;;   SPECIAL VARS
;;;; --------------------------------------------------------------------------

;;;; --------------------------------------------------------------------------
;;;;   UTIL FUNCTIONS
;;;; --------------------------------------------------------------------------

;;;; --------------------------------------------------------------------------
;;;;   WRAPPER FUNCTIONS
;;;; --------------------------------------------------------------------------

(defn get-subscription-expression [ multitopic-instance ]
  (core-util/assert-class MultiTopic multitopic-instance)
  (. multitopic-instance (get_subscription_expression)))

(defn get-expression-parameters [ multitopic-instance ]
  (core-util/assert-class MultiTopic multitopic-instance)
  (let [parameters (StringSeq.)]
    (. multitopic-instance (get_expression_parameters parameters))
    parameters))

(defn set-expression-parameters [ multitopic-instance parameters ]
  (core-util/assert-class MultiTopic multitopic-instance)
  (core-util/assert-class StringSeq parameters)
  (. multitopic-instance (set_expression_parameters parameters)))

;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
