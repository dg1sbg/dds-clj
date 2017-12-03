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
;;;;   WRAPPER FOR:  COM:RTI.DDS.TOPIC.TOPIC
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

(ns dds-clj.topic.topic

  (:require ;;[dds-clj.domain.participant-factory :as domain-participant-factory]
            [dds-clj.core.util :as core-util])

  (:import [com.rti.dds.topic

            Topic
            TopicListener
            TopicQos
            InconsistentTopicStatus
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

;;;; --------------------------------------------------------------------------
;;;;   TOPIC
;;;; --------------------------------------------------------------------------

(defn get-inconsistent-topic-status [ topic-instance ]
  (core-util/assert-class Topic topic-instance)
  (let [status (InconsistentTopicStatus.)]
    (. topic-instance (get_inconsistent_topic_status status))
    status))

(defn set-qos [ topic-instance qos ]
  (core-util/assert-class Topic topic-instance)
  (core-util/assert-class TopicQos qos)
  (. topic-instance (set_qos qos)))

(defn set-qos-with-profile [ topic-instance library-name profile-name ]
  (core-util/assert-class Topic topic-instance)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (. topic-instance (set_qos_with_profile library-name profile-name)))

(defn get-qos [ topic-instance ]
  (core-util/assert-class Topic topic-instance)
  (. topic-instance (get_qos)))

(defn set-listener [ topic-instance l mask ]
  (core-util/assert-class Topic topic-instance)
  (core-util/assert-class TopicListener l)
  (core-util/assert-class Integer mask)
  (. topic-instance (set_listener l mask)))

(defn get-listener [ topic-instance ]
  (core-util/assert-class Topic topic-instance)
  (. topic-instance (get_listener)))

;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
