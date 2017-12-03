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
;;;;   WRAPPER FOR:  COM:RTI.DDS.SUBSCRIPTION.DATAREADER
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

(ns dds-clj.subscription.datareader

  (:require [dds-clj.core.util :as core-util])

  (:import  [com.rti.dds.infrastructure

             Duration_t
             Locator_t
             LocatorSeq
             InstanceHandle_t
             InstanceHandleSeq
             SampleIdentity_t
             Time_t
             AckResponseData_t
             GUID_t
             ]

            [com.rti.dds.subscription

             Subscriber
             SubscriberQos
             SubscriberListener
             DataReader
             DataReaderQos
             DataReaderListener
             DataReaderSeq
             SampleRejectedStatus
             LivelinessChangedStatus
             RequestedDeadlineMissedStatus
             RequestedIncompatibleQosStatus
             SampleLostStatus
             SubscriptionMatchedStatus
             DataReaderCacheStatus
             DataReaderProtocolStatus
             SampleInfo
             SampleInfoSeq
             TopicQuery
             TopicQuerySelection
             ReadCondition
            ]

            [com.rti.dds.publication

            ]

            [com.rti.dds.topic

             TopicDescription
             TopicQos
             ]

            [com.rti.dds.publication.builtin

             PublicationBuiltinTopicData
            ]

            [com.rti.dds.domain.builtin

             ParticipantBuiltinTopicData
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

(defn set-qos [ datareader-instance qos ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class DataReaderQos qos)
  (. datareader-instance (set_qos qos)))

(defn set-qos-with-profile [ datareader-instance library-name profile-name ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (. datareader-instance (set_qos_with_profile library-name profile-name)))

(defn get-qos [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [qos (DataReaderQos.)]
    (. datareader-instance (get_qos qos))
    qos))

(defn set-listener [ datareader-instance l mask ]
  (core-util/assert-class DataReader datareader-instance)
  (when l
    (core-util/assert-class DataReaderListener l))
  (core-util/assert-class Integer mask)
  (. datareader-instance (set_listener l mask)))

(defn get-listener [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (. datareader-instance (get_listener)))

(defn get-sample-rejected-status [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [ status (SampleRejectedStatus.) ]
    (. datareader-instance (get_sample_rejected_status status))
    status))

(defn get-liveliness-changed-status [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [ status (LivelinessChangedStatus.) ]
    (. datareader-instance (get_liveliness_changed_status status))
    status))

(defn get-requested-deadline-missed-status [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [ status (RequestedDeadlineMissedStatus.) ]
    (. datareader-instance (get_requested_deadline_missed_status status))
    status))

(defn get-requested-incompatible-qos-status [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [ status (RequestedIncompatibleQosStatus.) ]
    (. datareader-instance (get_requested_incompatible_qos_status status))
    status))

(defn get-sample-lost-status [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [ status (SampleLostStatus.) ]
    (. datareader-instance (get_sample_lost_status status))
    status))

(defn get-subscription-matched-status [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [ status (SubscriptionMatchedStatus.) ]
    (. datareader-instance (get_subscription_matched_status status))
    status))

(defn get-datareader-cache-status [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [ status (DataReaderCacheStatus.) ]
    (. datareader-instance (get_datareader_cache_status status))
    status))

(defn get-datareader-protocol-status [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [ status (DataReaderProtocolStatus.) ]
    (. datareader-instance (get_datareader_protocol_status status))
    status))

(defn get-matched-publication-datareader-protocol-status [ datareader-instance publication-handle ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class InstanceHandle_t publication-handle)
  (let [ status (DataReaderProtocolStatus.) ]
    (. datareader-instance (get_matched_publication_datareader_protocol_status status publication-handle))
    status))

(defn get-matched-publications [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [ publication-handles (InstanceHandleSeq.) ]
    (. datareader-instance (get_matched_publications publication-handles))
    publication-handles))

(defn get-matched-publication-data [ datareader-instance publication-handle ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class InstanceHandle_t publication-handle)
  (let [ publication-data (PublicationBuiltinTopicData.) ]
    (. datareader-instance (get_matched_publication_data publication-data publication-handle))
    publication-data))

(defn get-matched-subscription-participant-data [ datareader-instance subscription-handle ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class InstanceHandle_t subscription-handle)
  (let [ participant-data (ParticipantBuiltinTopicData.) ]
    (. datareader-instance (get_matched_subscription_participant_data participant-data subscription-handle))
    participant-data))

(defn get-topicdescription [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (. datareader-instance (get_topicdescription)))

(defn get-subscriber [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (. datareader-instance (get_subscriber)))

(defn delete-contained-entities [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (. datareader-instance (delete-contained-entities)))

(defn wait-for-historical-data [ datareader-instance max-wait ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Duration_t max-wait)
  (. datareader-instance (wait_for_historical_data max-wait)))

(defn acknowledge-sample [ datareader-instance sample-info ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class SampleInfo sample-info)
  (. datareader-instance (acknowledge_sample sample-info)))

(defn acknowledge-all [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (. datareader-instance (acknowledge_all)))

(defn acknowledge-sample [ datareader-instance sample-info response-data ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class SampleInfo sample-info)
  (core-util/assert-class AckResponseData_t response-data)
  (. datareader-instance (acknowledge_sample sample-info response-data)))

(defn acknowledge-all [ datareader-instance response-data ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class AckResponseData_t response-data)
  (. datareader-instance (acknowledge_all response-data)))

(defn create-topic-query [ datareader-instance selection ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class TopicQuerySelection selection)
  (. datareader-instance (create_topic_query selection)))

(defn delete-topic-query [ datareader-instance query ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class TopicQuery query)
  (. datareader-instance (delete_topic_query query)))

(defn lookup-topic-query [ datareader-instance guid ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class GUID_t guid)
  (. datareader-instance (lookup_topic_query guid)))

(defn read-untyped [ datareader-instance max-samples sample-states view-states instance-states ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class Integer sample-states)
  (core-util/assert-class Integer view-states)
  (core-util/assert-class Integer instance-states)
  (let [received-data ()
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (read_untyped received-data info-seq max-samples sample-states view-states instance-states))
    (list received-data info-seq)))

(defn take-untyped [ datareader-instance max-samples sample-states view-states instance-states ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class Integer sample-states)
  (core-util/assert-class Integer view-states)
  (core-util/assert-class Integer instance-states)
  (let [received-data ()
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (take_untyped received-data info-seq max-samples sample-states view-states instance-states))
    (list received-data info-seq)))

(defn read-w-condition-untyped [ datareader-instance max-samples read-condition ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class ReadCondition read-condition)
  (let [received-data ()
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (read_w_condition_untyped received-data info-seq max-samples read-condition))
    (list received-data info-seq)))

(defn take-w-condition-untyped [ datareader-instance max-samples read-condition ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class ReadCondition read-condition)
  (let [received-data ()
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (take_w_condition_untyped received-data info-seq max-samples read-condition))
    (list received-data info-seq)))

(defn read-next-sample-untyped [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [received-data (Object.)
        sample-info (SampleInfo.)]
    (. datareader-instance (read_next_sample_untyped received-data sample-info))
    (list received-data sample-info)))

(defn take-next-sample-untyped [ datareader-instance ]
  (core-util/assert-class DataReader datareader-instance)
  (let [received-data (Object.)
        sample-info (SampleInfo.)]
    (. datareader-instance (take_next_sample_untyped received-data sample-info))
    (list received-data sample-info)))

(defn read-instance-untyped [ datareader-instance max-samples handle sample-states view-states instance-states ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class Integer sample-states)
  (core-util/assert-class Integer view-states)
  (core-util/assert-class Integer instance-states)
  (let [received-data (Object.)
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (read_instance_untyped received-data info-seq max-samples handle sample-states view-states instance-states))
    (list received-data info-seq)))

(defn take-instance-untyped [ datareader-instance max-samples handle sample-states view-states instance-states ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class Integer sample-states)
  (core-util/assert-class Integer view-states)
  (core-util/assert-class Integer instance-states)
  (let [received-data (Object.)
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (read_instance_untyped received-data info-seq max-samples handle sample-states view-states instance-states))
    (list received-data info-seq)))

(defn read-instance-w-condition-untyped [ datareader-instance max-samples handle read-condition ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class ReadCondition read-condition)
  (let [received-data (Object.)
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (read_instance_w_condition_untyped received-data info-seq max-samples handle read-condition))
    (list received-data info-seq)))

(defn take-instance-w-condition-untyped [ datareader-instance max-samples handle read-condition ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class ReadCondition read-condition)
  (let [received-data (Object.)
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (take_instance_w_condition_untyped received-data info-seq max-samples handle read-condition))
    (list received-data info-seq)))

(defn read-next-instance-untyped [ datareader-instance max-samples handle sample-states view-states instance-states ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class Integer sample-states)
  (core-util/assert-class Integer view-states)
  (core-util/assert-class Integer instance-states)
  (let [received-data '()
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (read_next_instance_untyped received-data info-seq max-samples handle sample-states view-states instance-states))
    (list received-data info-seq)))

(defn take-next-instance-untyped [ datareader-instance max-samples handle sample-states view-states instance-states ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class Integer sample-states)
  (core-util/assert-class Integer view-states)
  (core-util/assert-class Integer instance-states)
  (let [received-data '()
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (take_next_instance_untyped received-data info-seq max-samples handle sample-states view-states instance-states))
    (list received-data info-seq)))

(defn read-next-instance-w-condition-untyped [ datareader-instance max-samples handle read-condition ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class ReadCondition read-condition)
  (let [received-data '()
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (read_next_instance_untyped received-data info-seq max-samples handle read-condition))
    (list received-data info-seq)))

(defn take-next-instance-w-condition-untyped [ datareader-instance max-samples handle read-condition ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Integer max-samples)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class ReadCondition read-condition)
  (let [received-data '()
        info-seq (SampleInfoSeq.)]
    (. datareader-instance (take_next_instance_untyped received-data info-seq max-samples handle read-condition))
    (list received-data info-seq)))

(defn return-loan-untyped [ datareader-instance received-data info-seq ]
  (core-util/assert-class DataReader datareader-instance)
  ;;(core-util/assert-class List received-data)
  (core-util/assert-class SampleInfoSeq info-seq)
  (. datareader-instance (return_loan_untyped received-data info-seq)))

(defn get-key-value-untyped [ datareader-instance key-holder handle ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Object key-holder)
  (core-util/assert-class InstanceHandle_t handle)
  (. datareader-instance (get_key_value_untyped key-holder handle)))

(defn lookup-instance-untyped [ datareader-instance key-value ]
  (core-util/assert-class DataReader datareader-instance)
  (core-util/assert-class Object key-value)
  (. datareader-instance (lookup_instance_untyped key-value)))

;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
