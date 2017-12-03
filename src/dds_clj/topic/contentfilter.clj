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
;;;;   WRAPPER FOR:  COM:RTI.DDS.TOPIC.COMNTENTFILTER
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

(ns dds-clj.topic.contentfilter

  (:require [dds-clj.core.util :as core-util])

  (:import [com.rti.dds.infrastructure

            StringSeq
            InstanceHandle_t
            InstanceHandleSeq
            ObjectHolder
           ]

           [com.rti.dds.topic

            ContentFilter
            ContentFilteredTopic
            FilterSampleInfo
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

(defn compile [ contentfilter-instance new-compile-data expression parameters
                type-code type-class-name old-compile-data]
  (core-util/assert-class ContentFilter contentfilter-instance)
  (when new-compile-data
    (core-util/assert-class ObjectHolder new-compile-data))
  (core-util/assert-class String expression)
  (core-util/assert-class StringSeq parameters)
  (core-util/assert-class String type-class-name)
  (when old-compile-data
    (core-util/assert-class Object old-compile-data))
  ;; NOTE: type-code is always NIL. (See: https://community.rti.com/static/documentation/connext-dds/5.3.0/doc/api/connext_dds/api_java/interfacecom_1_1rti_1_1dds_1_1topic_1_1ContentFilter.html
  (. contentfilter-instance (compile new-compile-data expression parameters nil type-class-name old-compile-data)))

(defn evaluate [ contentfilter-instance compile-data sample meta-data ]
  (core-util/assert-class ContentFilter contentfilter-instance)
  (when compile-data
    (core-util/assert-class Object compile-data))
  (core-util/assert-class Object sample)
  (core-util/assert-class FilterSampleInfo meta-data)
  (. contentfilter-instance (evaluate compile-data sample meta-data)))

(defn finalize [ contentfilter-instance compile-data ]
  (core-util/assert-class ContentFilter contentfilter-instance)
  (core-util/assert-class Object compile-data)
  (. contentfilter-instance (finalize compile-data)))


;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
