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
;;;;   WRAPPER FOR:  COM:RTI.DDS.TOPIC.TOPICDESCRIPTION
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

(ns dds-clj.topic.description

  (:require [dds-clj.core.util :as core-util])

  (:import [com.rti.dds.topic

            TopicDescription
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

(defn get-type-name [ topicdescription-instance ]
  (core-util/assert-class TopicDescription topicdescription-instance)
  (. topicdescription-instance (get_type_name)))

(defn get-name [ topicdescription-instance ]
  (core-util/assert-class TopicDescription topicdescription-instance)
  (. topicdescription-instance (get_name)))

(defn get-participant [ topicdescription-instance ]
  (core-util/assert-class TopicDescription topicdescription-instance)
  (. topicdescription-instance (get_participant)))

;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
