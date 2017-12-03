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
;;;;   WRAPPER FOR:  COM:RTI.DDS.TOPIC.TOPICLISTENER
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

(ns dds-clj.publication.datawriter

  (:require ;;[dds-clj.domain.participant-factory :as domain-participant-factory]
            [dds-clj.core.util :as core-util])

  (:import  [com.rti.dds.infrastructure

             Duration_t
             Locator_t
             LocatorSeq
             InstanceHandle_t
             InstanceHandleSeq
             SampleIdentity_t
             Time_t
             ]

            [com.rti.dds.publication

             Publisher
             PublisherQos
             PublisherListener
             DataWriter
             DataWriterQos
             DataWriterListener
             DataWriterSeq
             DataWriterCacheStatus
             DataWriterProtocolStatus
             LivelinessLostStatus
             OfferedDeadlineMissedStatus
             OfferedIncompatibleQosStatus
             PublicationMatchedStatus
             ;; ReliableReaderActitivityChangedStatus
             ReliableWriterCacheChangedStatus
             ;; ReliableWriterCacheEventStatus
             ServiceRequestAcceptedStatus
            ]

            [com.rti.dds.topic

             Topic
             TopicQos
             ]

            [com.rti.dds.subscription.builtin

             SubscriptionBuiltinTopicData
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

(defn set-qos [ datawriter-instance qos ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class DataWriterQos qos)
  (. datawriter-instance (set_qos qos)))

(defn set-qos-with-profile [ datawriter-instance library-name profile-name ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (. datawriter-instance (set_qos_with_profile library-name profile-name)))

(defn get-qos [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [qos (DataWriterQos.)]
    (. datawriter-instance (get_qos qos))
    qos))

(defn set-listener [ datawriter-instance l mask ]
  (core-util/assert-class DataWriter datawriter-instance)
  (when l
    (core-util/assert-class DataWriterListener l))
  (core-util/assert-class Integer mask)
  (. datawriter-instance (set_listener l mask)))

(defn get-listener [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (. datawriter-instance (get_listener)))

(defn get-liveliness-lost-status [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ status (LivelinessLostStatus.) ]
    (. datawriter-instance (get_liveliness_lost_status status))
    status))

(defn get-offered-deadline-missed-status [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ status (OfferedDeadlineMissedStatus.) ]
    (. datawriter-instance (get_offered_deadline_missed_status status))
    status))

(defn get-offered-incompatible-qos-status [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ status (OfferedIncompatibleQosStatus.) ]
    (. datawriter-instance (get_offered_incompatible_qos_status status))
    status))

(defn get-publication-matched-status [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ status (PublicationMatchedStatus.) ]
    (. datawriter-instance (get_publication_matched_status status))
    status))

(defn get-reliable-writer-cache-changed-status [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ status (ReliableWriterCacheChangedStatus.) ]
    (. datawriter-instance (get_reliable_writer_cache_changed_status status))
    status))

(defn get-datawriter-cache-status [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ status (DataWriterCacheStatus.) ]
    (. datawriter-instance (get_datawriter_cache_status status))
    status))

(defn get-datawriter-protocol-status [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ status (DataWriterProtocolStatus.) ]
    (. datawriter-instance (get_datawriter_protocol_status status))
    status))

(defn get-matched-subscription-datawriter-protocol-status [ datawriter-instance subscription-handle ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class InstanceHandle_t subscription-handle)
  (let [ status (DataWriterProtocolStatus.) ]
    (. datawriter-instance (get_matched_subscription_datawriter_protocol_status status))
    status))

(defn get-matched-subscription-datawriter-protocol-status-by-locator [ datawriter-instance locator ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Locator_t locator)
  (let [ status (DataWriterProtocolStatus.) ]
    (. datawriter-instance (get_matched_subscription_datawriter_protocol_status_by_locator status locator))
    status))

(defn get-service-request-accepted-status [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ status (ServiceRequestAcceptedStatus.) ]
    (. datawriter-instance (get_service_request_accepted_status status))
    status))

(defn get-matched-subscription-locators [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ locators (LocatorSeq.) ]
    (. datawriter-instance (get_matched_subscription_locators locators))
    locators))

(defn get-matched-subscriptions [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (let [ subscription-handles (InstanceHandleSeq.) ]
    (. datawriter-instance (get_matched_subscriptions subscription-handles))
    subscription-handles))

(defn get-matched-subscription-data [ datawriter-instance subscription-handle ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class InstanceHandle_t subscription-handle)
  (let [ subscription-data (SubscriptionBuiltinTopicData.) ]
    (. datawriter-instance (get_matched_subscription_data subscription-data subscription-handle))
    subscription-data))

(defn get-matched-subscription-participant-data [ datawriter-instance subscription-handle ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class InstanceHandle_t subscription-handle)
  (let [ participant-data (ParticipantBuiltinTopicData.) ]
    (. datawriter-instance (get_matched_subscription_participant_data participant-data subscription-handle))
    participant-data))

(defn get-topic [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (. datawriter-instance (get_topic)))

(defn get-publisher [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (. datawriter-instance (get_publisher)))

(defn wait-for-acknowledgements [ datawriter-instance max-wait ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Duration_t max-wait)
  (. datawriter-instance (wait_for_acknowledgements max-wait)))

(defn is-sample-app-acknowledged [ datawriter-instance identity ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class SampleIdentity_t identity)
  (. datawriter-instance (is_sample_app_acknowledged identity)))

(defn wait-for-asynchronous-publishing [ datawriter-instance max-wait ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Duration_t max-wait)
  (. datawriter-instance (wait_for_asynchronous_publishing max-wait)))

(defn assert-liveliness [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (. datawriter-instance (assert_liveliness)))

(defn flush [ datawriter-instance ]
  (core-util/assert-class DataWriter datawriter-instance)
  (. datawriter-instance (flush)))

(defn register-instance-untyped [ datawriter-instance instance-data ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object instance-data)
  (. datawriter-instance (register_instance_untyped instance-data)))

(defn register-instance-w-timestamp-untyped [ datawriter-instance instance-data  source-timestamp]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object instance-data)
  (core-util/assert-class Time_t source-timestamp)
  (. datawriter-instance (register_instance_w_timestamp_untyped instance-data source-timestamp)))

(defn unregister-instance-untyped [ datawriter-instance instance-data handle ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object instance-data)
  (core-util/assert-class InstanceHandle_t handle)
  (. datawriter-instance (unregister_instance_untyped instance-data handle)))

(defn register-instance-w-timestamp-untyped [ datawriter-instance instance-data handle source-timestamp ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object instance-data)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class Time_t source-timestamp)
  (. datawriter-instance (unregister_instance_w_timestamp_untyped instance-data handle source-timestamp)))

(defn write-untyped [ datawriter-instance instance-data handle ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object instance-data)
  (core-util/assert-class InstanceHandle_t handle)
  (. datawriter-instance (write_untyped instance-data handle)))

(defn write-w-timestamp-untyped [ datawriter-instance instance-data handle source-timestamp ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object instance-data)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class Time_t source-timestamp)
  (. datawriter-instance (write_w_timestamp_untyped instance-data handle source-timestamp)))

(defn dispose-untyped [ datawriter-instance instance-data handle ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object instance-data)
  (core-util/assert-class InstanceHandle_t handle)
  (. datawriter-instance (dispose_untyped instance-data handle)))

(defn dispose-w-timestamp-untyped [ datawriter-instance instance-data handle source-timestamp ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object instance-data)
  (core-util/assert-class InstanceHandle_t handle)
  (core-util/assert-class Time_t source-timestamp)
  (. datawriter-instance (dispose_w_timestamp_untyped instance-data handle source-timestamp)))

(defn get-key-value-untyped [ datawriter-instance key-holder ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object key-holder)
  (. datawriter-instance (get_key_value_untyped key-holder)))

(defn lookup-instance-untyped [ datawriter-instance key-value ]
  (core-util/assert-class DataWriter datawriter-instance)
  (core-util/assert-class Object key-value)
  (. datawriter-instance (lookup_instance_untyped key-value)))


;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
