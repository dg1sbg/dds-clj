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
;;;;   WRAPPER FOR:  COM:RTI.DDS.TOPIC.COMNTENTFILTEREDTOPIC
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
            ;;InstanceHandle_t
            ;;InstanceHandleSeq
            ObjectHolder
           ]

           [com.rti.dds.topic

            ;;ContentFilter
            ContentFilteredTopic
            ;;FilterSampleInfo
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

(defn get-filter-expression [ contentfilteredtopic-instance ]
  (core-util/assert-class ContentFilteredTopic contentfilteredtopic-instance)
  (. contentfilteredtopic-instance (get_filter_expression)))

(defn get-expression-parameters [ contentfilteredtopic-instance ]
  (core-util/assert-class ContentFilteredTopic contentfilteredtopic-instance)
  (let [parameters (StringSeq.)]
    (. contentfilteredtopic-instance (get_expression_parameters parameters))
    parameters))

(defn set-expression-parameters [ contentfilteredtopic-instance parameters ]
  (core-util/assert-class ContentFilteredTopic contentfilteredtopic-instance)
  (core-util/assert-class StringSeq parameters)
  (. contentfilteredtopic-instance (set_expression_parameters parameters)))

(defn set-expression [ contentfilteredtopic-instance expression parameters ]
  (core-util/assert-class ContentFilteredTopic contentfilteredtopic-instance)
  (core-util/assert-class String expression)
  (core-util/assert-class StringSeq parameters)
  (. contentfilteredtopic-instance (set_expression expression parameters)))

(defn get-related-topic [ contentfilteredtopic-instance ]
  (core-util/assert-class ContentFilteredTopic contentfilteredtopic-instance)
  (. contentfilteredtopic-instance (get_related_topic)))

(defn append-to-expression-parameter [ contentfilteredtopic-instance index val ]
  (core-util/assert-class ContentFilteredTopic contentfilteredtopic-instance)
  (core-util/assert-class Integer index)
  (core-util/assert-class String val)
  (. contentfilteredtopic-instance (append_to_expression_parameter index val)))

(defn remove-from-expression-parameter [ contentfilteredtopic-instance index val ]
  (core-util/assert-class ContentFilteredTopic contentfilteredtopic-instance)
  (core-util/assert-class Integer index)
  (core-util/assert-class String val)
  (. contentfilteredtopic-instance (remove__expression_parameter index val)))

;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
