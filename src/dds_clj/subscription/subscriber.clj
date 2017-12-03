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
;;;;   WRAPPER FOR:  COM:RTI.DDS.SUBSCRIPTION.SUBSCRIBER
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

(ns dds-clj.subscription.subscriber

  (:require ;;[dds-clj.domain.participant-factory :as domain-participant-factory]
            [dds-clj.core.util :as core-util])

  (:import  [com.rti.dds.infrastructure

             Duration_t
             ]

            [com.rti.dds.subscription

             Subscriber
             SubscriberQos
             SubscriberListener
             DataReader
             DataReaderQos
             DataReaderListener
             DataReaderSeq
            ]

            [com.rti.dds.topic

             TopicDescription
             TopicQos
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

(defn get-default-dataeader-qos [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (let [qos (DataReaderQos.)]
    (. subscriber-instance (get_default_datareader_qos qos))
    qos))

(defn set-default-datareader-qos [ subscriber-instance qos ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class DataReaderQos qos)
  (. subscriber-instance (set_default_datareader_qos qos)))

(defn set-default-datareader-qos-with-profile [ subscriber-instance library-name profile-name ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (. subscriber-instance (set_default_datareader_qos_with_profile library-name profile-name)))

(defn create-datareader [ subscriber-instance topic qos listener mask ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class TopicDescription topic)
  (core-util/assert-class DataReaderQos qos)
  (when listener
    (core-util/assert-class DataReaderListener listener))
  (core-util/assert-class Integer mask)
  (. subscriber-instance (create_datareader topic qos listener mask)))

(defn create-datareader-with-profile [ subscriber-instance topic library-name profile-name listener mask ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class TopicDescription topic)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (when listener
    (core-util/assert-class DataReaderListener listener))
  (core-util/assert-class Integer mask)
  (. subscriber-instance (create_datareader_with_profile topic library-name profile-name listener mask)))

(defn delete-datareader [ subscriber-instance datareader ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class DataReader datareader)
  (. subscriber-instance (delete_datareader datareader)))

(defn lookup-datareader [ subscriber-instance topic-name ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class String topic-name)
  (. subscriber-instance (lookup_datareader topic-name)))

(defn get-datareaders [ subscriber-instance sample-states view-states instance-states ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class Integer sample-states)
  (core-util/assert-class Integer view-states)
  (core-util/assert-class Integer instance-states)
  (let [ readers (DataReaderSeq.)]
    (. subscriber-instance (get_datareaders readers sample-states view-states instance-states ))
    readers))

(defn get-all-datareaders [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (let [ readers (DataReaderSeq.)]
    (. subscriber-instance (get_all_datareaders readers))
    readers))

(defn notify-datareaders [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (. subscriber-instance (notify_datareaders)))

(defn set-qos [ subscriber-instance qos ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class SubscriberQos qos)
  (. subscriber-instance (set_qos qos)))

(defn set-qos-with-profile [ subscriber-instance library-name profile-name ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (. subscriber-instance (set_qos_with_profile library-name profile-name)))

(defn get-qos [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (let [qos (SubscriberQos.)]
    (. subscriber-instance (get_qos qos))
    qos))

(defn get-default-library [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (. subscriber-instance (get_default_library)))

(defn set-default-library [ subscriber-instance library-name ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class String library-name)
  (. subscriber-instance (set_default_library library-name)))

(defn get-default-profile [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (. subscriber-instance (get_default_profile)))

(defn set-default-profile [ subscriber-instance library-name profile-name ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (. subscriber-instance (set_default_profile library-name profile-name)))

(defn get-default-profile-library [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (. subscriber-instance (get_default_profile_library)))

(defn set-listener [ subscriber-instance l mask ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class SubscriberListener l)
  (core-util/assert-class Integer mask)
  (. subscriber-instance (set_listener l mask)))

(defn get-listener [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (. subscriber-instance (get_listener)))

(defn begin-access [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (. subscriber-instance (begin_access)))

(defn end-access [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (. subscriber-instance (end_access)))

(defn copy-from-topic-qos [ subscriber-instance datareader-qos topic-qos ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class DataReaderQos datareader-qos)
  (core-util/assert-class TopicQos topic-qos)
  (. subscriber-instance (copy_from_topic_qos datareader-qos topic-qos)))

(defn get-participant [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (. subscriber-instance (get_participant)))

(defn delete-contained-entities [ subscriber-instance ]
  (core-util/assert-class Subscriber subscriber-instance)
  (. subscriber-instance (delete_contained_entities)))

(defn lookup-datareader-by-name[ subscriber-instance datareader-name ]
  (core-util/assert-class Subscriber subscriber-instance)
  (core-util/assert-class String datareader-name)
  (. subscriber-instance (lookup_datareader_by_name datareader-name)))



;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
