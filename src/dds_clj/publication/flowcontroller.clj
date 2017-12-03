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
;;;;   WRAPPER FOR:  COM:RTI.DDS.PUBLICATION.FLOWCONTROLLER
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

(ns dds-clj.publication.flowcontroller

  (:require ;;[dds-clj.domain.participant-factory :as domain-participant-factory]
            [dds-clj.core.util :as core-util])

  (:import  [com.rti.dds.infrastructure

             ;; Duration_t
             ;; Locator_t
             ;; LocatorSeq
             ;; InstanceHandle_t
             ;; InstanceHandleSeq
             ;; SampleIdentity_t
             ;; Time_t
             ]

            [com.rti.dds.publication

             ;; Publisher
             ;; PublisherQos
             ;; PublisherListener
             ;; DataWriter
             ;; DataWriterQos
             ;; DataWriterListener
             ;; DataWriterSeq
             ;; DataWriterCacheStatus
             ;; DataWriterProtocolStatus
             ;; LivelinessLostStatus
             ;; OfferedDeadlineMissedStatus
             ;; OfferedIncompatibleQosStatus
             ;; PublicationMatchedStatus
             ;; ;; ReliableReaderActitivityChangedStatus
             ;; ReliableWriterCacheChangedStatus
             ;; ;; ReliableWriterCacheEventStatus
             ;; ServiceRequestAcceptedStatus
             FlowController
             FlowControllerProperty_t
            ]

            [com.rti.dds.topic

             ;; Topic
             ;; TopicQos
             ]

            [com.rti.dds.subscription.builtin

             ;; SubscriptionBuiltinTopicData
            ]

            [com.rti.dds.domain.builtin

             ;; ParticipantBuiltinTopicData
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

(defn get-name [ flowcontroller-instance ]
  (core-util/assert-class FlowController flowcontroller-instance)
  (. flowcontroller-instance (get_name)))

(defn get-participant [ flowcontroller-instance ]
  (core-util/assert-class FlowController flowcontroller-instance)
  (. flowcontroller-instance (get_participant)))

(defn set-poperty [ flowcontroller-instance prop ]
  (core-util/assert-class FlowController flowcontroller-instance)
  (core-util/assert-class FlowControllerProperty_t prop)
  (. flowcontroller-instance (set_property prop)))

(defn get-poperty [ flowcontroller-instance ]
  (core-util/assert-class FlowController flowcontroller-instance)
  (let [prop (FlowControllerProperty_t.)]
    (. flowcontroller-instance (get_property prop))
    prop))

(defn trigger-flow [ flowcontroller-instance ]
  (core-util/assert-class FlowController flowcontroller-instance)
  (. flowcontroller-instance (trigger_flow)))




;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
