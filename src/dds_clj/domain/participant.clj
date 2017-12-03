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
;;;;   WRAPPER FOR:  COM:RTI.DDS.DOMAIN
;;;;
;;;; --------------------------------------------------------------------------
;;;;
;;;;   OPEN ISSUES:
;;;;
;;;;   001 TODO: Use #'assert-class instead #'assert to make code simpler
;;;;   002 TODO: Write tests
;;;;
;;;; ==========================================================================

;;;; --------------------------------------------------------------------------
;;;;   NAMESPACE
;;;; --------------------------------------------------------------------------

(ns dds-clj.domain.participant

  (:require [dds-clj.domain.participant-factory :as domain-participant-factory]
            [dds-clj.core.util :as core-util])

  (:import [com.rti.dds.infrastructure

            StringSeq
            Duration_t
            InstanceHandle_t
            InstanceHandleSeq
            Time_t
            EndpointGroup_t
           ]

           [com.rti.dds.domain

            ;; DomainParticipantFactory
            ;; DomainParticipantFactoryQos
            DomainParticipant
            ;; DomainParticipantAdapter
            DomainParticipantListener
            DomainParticipantQos
            DomainParticipantProtocolStatus
           ]

           [com.rti.dds.publication

            FlowController
            FlowControllerProperty_t
            DataWriter
            DataWriterQos
            DataWriterListener
            Publisher
            PublisherListener
            PublisherQos
            PublisherSeq
           ]

           [com.rti.dds.subscription

            DataReader
            DataReaderQos
            DataReaderListener
            Subscriber
            SubscriberQos
            SubscriberListener
            SubscriberSeq
           ]

           [com.rti.dds.topic

            Topic
            TopicDescription
            TopicListener
            TopicQos
            TypeSupport
            ContentFilteredTopic
            MultiTopic
            ContentFilter
           ]

           [com.rti.dds.domain.builtin

            ParticipantBuiltinTopicData

            ;; FIXME: TopicBuiltinTopicData is not recogbnized as a Java class...
            #_TopicBuiltinTopicData
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
;;;;   DOMAIN PARTICIPANT
;;;; --------------------------------------------------------------------------

;; RTI Connext DDS Extension
(defn get-default-flowcontroller-property [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (let [ prop (FlowControllerProperty_t.)]
    (. participant-instance (get_default_flowcontroller_property prop))
    prop))

;; RTI Connext DDS Extension
(defn set-default-flowcontroller-property [ participant-instance prop ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? FlowControllerProperty_t prop) (str "Argument \"prop\" not an instance of class FlowControllerProperty_t: " prop))
  (. participant-instance (set_default_flowcontroller_property prop)))

(defn get-default-topic-qos [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (let [ topic-qos (TopicQos.)]
    (. participant-instance (get_default_topic_qos topic-qos))
    topic-qos))

(defn set-default-topic-qos [ participant-instance topic-qos ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? TopicQos topic-qos) (str "Argument \"topic-qos\" not an instance of class TopicQos: " topic-qos))
  (. participant-instance (set_default_topic_qos topic-qos)))

;; RTI Connext DDS Extension
(defn set-default-topic-qos-with-profile [ participant-instance library-name profile-name ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (. participant-instance (set_default_topic_qos_with_profile library-name profile-name )))

(defn get-default-publisher-qos [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (let [ publisher-qos (PublisherQos.)]
    (. participant-instance (get_default_publisher_qos publisher-qos))
    publisher-qos))

(defn set-default-publisher-qos [ participant-instance publisher-qos ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? PublisherQos publisher-qos) (str "Argument \"publisher-qos\" not an instance of class PublisherQos: " publisher-qos))
  (. participant-instance (set_default_publisher_qos publisher-qos)))

;; RTI Connext DDS Extension
(defn set-default-publisher-qos-with-profile [ participant-instance library-name profile-name ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (. participant-instance (set_default_publisher_qos_with_profile library-name profile-name )))

(defn get-default-datawriter-qos [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (let [ datawriter-qos (DataWriterQos.)]
    (. participant-instance (get_default_datawriter_qos datawriter-qos))
    datawriter-qos))

(defn set-default-datawriter-qos [ participant-instance datawriter-qos ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? DataWriterQos datawriter-qos) (str "Argument \"datawriter-qos\" not an instance of class DataWriterQos: " datawriter-qos))
  (. participant-instance (set_default_datawriter_qos datawriter-qos)))

;; RTI Connext DDS Extension
(defn set-default-datawriter-qos-with-profile [ participant-instance library-name profile-name ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (. participant-instance (set_default_datawriter_qos_with_profile library-name profile-name )))

(defn get-default-datareader-qos [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (let [ datareader-qos (DataReaderQos.)]
    (. participant-instance (get_default_datareader_qos datareader-qos))
    datareader-qos))

(defn set-default-datareader-qos [ participant-instance datareader-qos ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? DataReaderQos datareader-qos) (str "Argument \"datareader-qos\" not an instance of class DataReaderQos: " datareader-qos))
  (. participant-instance (set_default_datawriter_qos datareader-qos)))

;; RTI Connext DDS Extension
(defn set-default-datareader-qos-with-profile [ participant-instance library-name profile-name ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (. participant-instance (set_default_datareader_qos_with_profile library-name profile-name )))

(defn get-default-subscriber-qos [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (let [ subscriber-qos (SubscriberQos.)]
    (. participant-instance (get_default_subscriber_qos subscriber-qos))
    subscriber-qos))

(defn set-default-subscriber-qos [ participant-instance subscriber-qos ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? SubscriberQos subscriber-qos) (str "Argument \"subscriber-qos\" not an instance of class SubscriberQos: " subscriber-qos))
  (. participant-instance (set_default_subscriber_qos subscriber-qos)))

;; RTI Connext DDS Extension
(defn set-default-subscriber-qos-with-profile [ participant-instance library-name profile-name ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (. participant-instance (set_default_subscriber_qos_with_profile library-name profile-name )))

;; RTI Connext DDS Extension
(defn create-flowcontroller [ participant-instance name props ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String name) (str "Argument \"name\" not an instance of class String: " name))
  (assert (instance? FlowControllerProperty_t props) (str "Argument \"props\" not an instance of class FlowControllerProperty_t: " props))
  (. participant-instance (create_flowcontroller name props)))

;; RTI Connext DDS Extension
(defn delete-flowcontroller [ participant-instance fc ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? FlowController fc) (str "Argument \"fc\" not an instance of class FlowController: " fc))
  (. participant-instance (delete_flowcontroller fc)))

(defn create-publisher [ participant-instance qos listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? PublisherQos qos) (str "Argument \"qos\" not an instance of class PublisherQos: " qos))
  (when listener
    (assert (instance? PublisherListener listener) (str "Argument \"listener\" not an instance of class PublisherListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_publisher qos listener mask)))

;; RTI Connext DDS Extension
(defn create-publisher-with-profile [ participant-instance library-name profile-name listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (when listener
    (assert (instance? PublisherListener listener) (str "Argument \"lsistener\" not an instance of class PublisherListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_publisher_with_profile library-name profile-name listener mask)))

(defn delete-publisher [ participant-instance publisher ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? Publisher publisher) (str "Argument \"publisher\" not an instance of class Publisher: " publisher))
  (. participant-instance (delete_publisher publisher)))

(defn create-subscriber [ participant-instance qos listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? SubscriberQos qos) (str "Argument \"qos\" not an instance of class SubscriberQos: " qos))
  (when listener
    (assert (instance? SubscriberListener listener) (str "Argument \"lsistener\" not an instance of class SubscriberListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_subscriber qos listener mask)))

;; RTI Connext DDS Extension
(defn create-subscriber-with-profile [ participant-instance library-name profile-name listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (when listener
    (assert (instance? SubscriberListener listener) (str "Argument \"listener\" not an instance of class SubscriberListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_subscriber_with_profile library-name profile-name listener mask)))

(defn delete-subscriber [ participant-instance subscriber ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? Subscriber subscriber) (str "Argument \"subscriber\" not an instance of class Subscriber: " subscriber))
  (. participant-instance (delete_subscriber subscriber)))

(defn create-datawriter [ participant-instance topic qos listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? Topic topic) (str "Argument \"topic\" not an instance of class Topic: " topic))
  (assert (instance? DataWriterQos qos) (str "Argument \"qos\" not an instance of class DataWriterQos: " qos))
  (when listener
    (assert (instance? DataWriterListener listener) (str "Argument \"listener\" not an instance of class PublisherListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_datawriter qos listener mask)))

;; RTI Connext DDS Extension
(defn create-datawriter-with-profile [ participant-instance topic library-name profile-name listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? Topic topic) (str "Argument \"topic\" not an instance of class Topic: " topic))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (when listener
    (assert (instance? DataWriterListener listener) (str "Argument \"lsistener\" not an instance of class DataWriterListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_datawriter_with_profile topic library-name profile-name listener mask)))

(defn delete-datawriter [ participant-instance datawriter ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? DataWriter datawriter) (str "Argument \"datawriter\" not an instance of class DataWriter: " datawriter))
  (. participant-instance (delete_datawriter datawriter)))

(defn create-datareader [ participant-instance topic-description qos listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? TopicDescription topic-description) (str "Argument \"topic-description\" not an instance of class TopicDescription: " topic-description))
  (assert (instance? DataReaderQos qos) (str "Argument \"qos\" not an instance of class DataReaderQos: " qos))
  (when listener
    (assert (instance? DataReaderListener listener) (str "Argument \"listener\" not an instance of class DataReaderListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_datareader topic-description qos listener mask)))

;; RTI Connext DDS Extension
(defn create-datareader-with-profile [ participant-instance topic-description library-name profile-name listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? TopicDescription topic-description) (str "Argument \"topic-description\" not an instance of class TopicDescription: " topic-description))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (when listener
    (assert (instance? DataReaderListener listener) (str "Argument \"listener\" not an instance of class DataReaderListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_datareader_with_profile topic-description library-name profile-name listener mask)))

(defn delete-datareader [ participant-instance datareader ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? DataReader datareader) (str "Argument \"datareader\" not an instance of class DataReader: " datareader))
  (. participant-instance (delete_datareader datareader)))

(defn create-topic [ participant-instance topic-name type-name qos listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String topic-name) (str "Argument \"topic-name\" not an instance of class String: " topic-name))
  (assert (instance? String type-name) (str "Argument \"type-name\" not an instance of class String: " type-name))
  (assert (instance? TopicQos qos) (str "Argument \"qos\" not an instance of class TopicQos: " qos))
  (when listener
    (assert (instance? TopicListener listener) (str "Argument \"listener\" not an instance of class TopicListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_topic topic-name type-name qos listener mask)))

;; RTI Connext DDS Extension
(defn create-topic-with-profile [ participant-instance topic-name type-name library-name profile-name listener mask ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String topic-name) (str "Argument \"topic-name\" not an instance of class String: " topic-name))
  (assert (instance? String type-name) (str "Argument \"type-name\" not an instance of class String: " type-name))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (when listener
    (assert (instance? TopicListener listener) (str "Argument \"listener\" not an instance of class TopicListener: " listener)))
  (assert (instance? Integer mask) (str "Argument \"mask\" not an instance of class Integer: " mask))
  (. participant-instance (create_topic_with_profile topic-name type-name library-name profile-name listener mask)))

(defn delete-topic [ participant-instance topic ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? Topic topic) (str "Argument \"topic\" not an instance of class Topic: " topic))
  (. participant-instance (delete_topic topic)))

(defn create-contentfilteredtopic [ participant-instance name related-topic filter-expression expression-parameters ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String name) (str "Argument \"name\" not an instance of class String: " name))
  (assert (instance? Topic related-topic) (str "Argument \"related-topic\" not an instance of class Topic: " related-topic))
  (assert (instance? String filter-expression) (str "Argument \"filter-expressiopn\" not an instance of class String: " filter-expression))
  (assert (instance? StringSeq expression-parameters) (str "Argument \"expression-parameters\" not an instance of class StringSeq: " expression-parameters))
  (. participant-instance (create_contentfilteredtopic name related-topic filter-expression expression-parameters)))

(defn create-contentfilteredtopic-with-filter [ participant-instance name related-topic filter-expression expression-parameters filter-name]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String name) (str "Argument \"name\" not an instance of class String: " name))
  (assert (instance? Topic related-topic) (str "Argument \"related-topic\" not an instance of class Topic: " related-topic))
  (assert (instance? String filter-expression) (str "Argument \"filter-expressiopn\" not an instance of class String: " filter-expression))
  (assert (instance? StringSeq expression-parameters) (str "Argument \"expression-parameters\" not an instance of class StringSeq: " expression-parameters))
  (assert (instance? String filter-name) (str "Argument \"filter-name\" not an instance of class String: " filter-name))
  (. participant-instance (create_contentfilteredtopic_with_filter name related-topic filter-expression expression-parameters filter-name)))

(defn delete-contentfilteredtopic [ participant-instance contentfilteredtopic ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? ContentFilteredTopic contentfilteredtopic) (str "Argument \"contentfilteredtopic\" not an instance of class ContentFilteredTopic: " contentfilteredtopic))
  (. participant-instance (delete_contentfilteredtopic contentfilteredtopic)))

(defn create-multitopic [ participant-instance name type-name subscription-expression expression-parameters ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String name) (str "Argument \"name\" not an instance of class String: " name))
  (assert (instance? String type-name) (str "Argument \"type-name\" not an instance of class String: " type-name))
  (assert (instance? String subscription-expression) (str "Argument \"subscription-expressiopn\" not an instance of class String: " subscription-expression))
  (assert (instance? StringSeq expression-parameters) (str "Argument \"expression-parameters\" not an instance of class StringSeq: " expression-parameters))
  (. participant-instance (create_multitopic name type-name subscription-expression expression-parameters)))

(defn delete-multitopic [ participant-instance multitopic ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? MultiTopic multitopic) (str "Argument \"multitopic\" not an instance of class MultiTopic: "multitopic))
  (. participant-instance (delete_multitopic multitopic)))

(defn set-qos [ participant-instance qos ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? DomainParticipantQos qos) (str "Argument \"qos\" not an instance of class DomainParticipantQos: " qos))
  (. participant-instance (set_qos qos)))

;; RTI Connext DDS Extension
(defn set-qos-with-profile [ participant-instance library-name profile-name ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (. participant-instance (set_qos_with_profile library-name profile-name)))

(defn get-qos [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (let [ qos (DomainParticipantQos.)]
    (. participant-instance (get_qos qos))
    qos))

;; RTI Connext DDS Extension
(defn get-default-library [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (. participant-instance (get_default_library)))

;; RTI Connext DDS Extension
(defn set-default-library [ participant-instance library-name]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (. participant-instance (set_default_library library-name)))

;; RTI Connext DDS Extension
(defn get-default-profile [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (. participant-instance (get_default_profile)))

;; RTI Connext DDS Extension
(defn set-default-profile [ participant-instance library-name profile-name]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String library-name) (str "Argument \"library-name\" not an instance of class String: " library-name))
  (assert (instance? String profile-name) (str "Argument \"profile-name\" not an instance of class String: " profile-name))
  (. participant-instance (set_default_profile library-name profile-name)))

;; RTI Connext DDS Extension
(defn get-default-profile-library [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (. participant-instance (get_default_profile_library)))

(defn set-listener [ participant-instance listener ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? DomainParticipantListener listener) (str "Argument \"listener\" not an instance of class DomainParticipantListener: " listener))
  (. participant-instance (set_listener listener)))

(defn get-listener [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (. participant-instance (get_listener)))

(defn get-publishers [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (let [ publishers (PublisherSeq.) ]
    (. participant-instance (get_publishers publishers))
    publishers))

(defn get-subscribers [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (let [ subscribers (SubscriberSeq.) ]
    (. participant-instance (get_subscribers subscribers))
    subscribers))

(defn get-builtin-subscriber [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (. participant-instance (get_builtin_subscriber)))

;; RTI Connext DDS Extension
(defn lookup-flowcontroller [ participant-instance name ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String name) (str "Argument \"name\" not an instance of class String: " name))
  (. participant-instance (lookup_flowcontroller name)))

;; RTI Connext DDS Extension
(defn find-topic [ participant-instance topic-name timeout ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String topic-name) (str "Argument \"topic-name\" not an instance of class String: " topic-name))
  (assert (instance? Duration_t timeout) (str "Argument \"timeout\" not an instance of class Duration_t: " timeout))
  (. participant-instance (find-topic topic-name timeout)))

;; RTI Connext DDS Extension
(defn lookup-topicdescription [ participant-instance topic-name ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String topic-name) (str "Argument \"topic-name\" not an instance of class String: " topic-name))
  (. participant-instance (lookup_topicdescription topic-name)))

(defn ignore-participant [ participant-instance handle ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? InstanceHandle_t handle) (str "Argument \"handle\" not an instance of class InstanceHandle_t: " handle))
  (. participant-instance (ignore_participant handle)))

(defn ignore-topic [ participant-instance handle ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? InstanceHandle_t handle) (str "Argument \"handle\" not an instance of class InstanceHandle_t: " handle))
  (. participant-instance (ignore_topic handle)))

(defn ignore-publication [ participant-instance handle ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? InstanceHandle_t handle) (str "Argument \"handle\" not an instance of class InstanceHandle_t: " handle))
  (. participant-instance (ignore_publication handle)))

(defn ignore-subscription [ participant-instance handle ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? InstanceHandle_t handle) (str "Argument \"handle\" not an instance of class InstanceHandle_t: " handle))
  (. participant-instance (ignore_subscription handle)))

(defn get-domain-id [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (. participant-instance (get_domain_id)))

(defn assert-liveliness [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (. participant-instance (assert_liveliness)))

(defn delete-contained-entities [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (. participant-instance (delete_contained_entities)))

;; RTI Connext DDS Extension
(defn add-peer [ participant-instance peer-desc-string ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String peer-desc-string) (str "Argument \"peer-desc-string\" not an instance of class String: " peer-desc-string))
  (. participant-instance (add_peer peer-desc-string)))

;; RTI Connext DDS Extension
(defn remove-peer [ participant-instance peer-desc-string ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String peer-desc-string) (str "Argument \"peer-desc-string\" not an instance of class String: " peer-desc-string))
  (. participant-instance (remove_peer peer-desc-string)))

(defn get-current-time [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (let [ current-time (Time_t.) ]
    (. participant-instance (get_current_time current-time))
    current-time))

(defn get-discovered-participants [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (let [ handles (InstanceHandleSeq.) ]
    (. participant-instance (get_discovered_participants handles))
    handles))

(defn get-discovered-participant-data [ participant-instance participant-handle ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? InstanceHandle_t participant-handle) (str "Argument \"participant-handle\" not an instance of class InstancdeHandle_t: " participant-handle))
  (let [ data (ParticipantBuiltinTopicData.) ]
    (. participant-instance (get_discovered_participant_data data participant-handle))
    data))

(defn get-discovered-topics [ participant-instance ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (let [ handles (InstanceHandleSeq.) ]
    (. participant-instance (get_discovered_topics handles))
    handles))

;; FIXME: TopicBuiltinTopicData is not recogbnized as a Java class...
#_ (defn get-discovered-topic-data [ participant-instance topic-handle ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? InstanceHandle_t topic-handle) (str "Argument \"topic-handle\" not an instance of class InstancdeHandle_t: " topic-handle))
  (let [ data (TopicBuiltinTopicData.) ]
    (. participant-instance (get_discovered_topic_data data topic-handle))
    data))

(defn contains-entity [ participant-instance handle ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? InstanceHandle_t handle) (str "Argument \"handle\" not an instance of class InstancdeHandle_t: " handle))
  (. participant-instance (contains_entity handle)))

(defn register-durable-subscription [ participant-instance group topic-name ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? EndpointGroup_t group) (str "Argument \"group\" not an instance of class EndpointGroup_t: " group))
  (assert (instance? String topic-name) (str "Argument \"topic-name\" not an instance of class String: " topic-name))
  (. participant-instance (register_durable_subscription group topic-name)))

(defn delete-durable-subscription [ participant-instance group ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? EndpointGroup_t group) (str "Argument \"group\" not an instance of class EndpointGroup_t: " group))
  (. participant-instance (delete_durable_subscription group)))

(defn resume-endpoint-discovery [ participant-instance remote-participant-handle ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? InstanceHandle_t remote-participant-handle) (str "Argument \"remote-participant-handle\" not an instance of class InstanceHandle_t: " remote-participant-handle))
  (. participant-instance (resume_endpoint_discovery remote-participant-handle)))

(defn register-contentfilter [ participant-instance filter-name contentfilter ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String filter-name) (str "Argument \"filter-name\" not an instance of class String: " filter-name))
  (assert (instance? ContentFilter contentfilter) (str "Argument \"contnetfilter\" not an instance of class ContentFiolter: " contentfilter))
  (. participant-instance (register_contentfilter filter-name contentfilter)))

(defn lookup-contentfilter [ participant-instance filter-name  ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String filter-name) (str "Argument \"filter-name\" not an instance of class String: " filter-name))
  (. participant-instance (lookup_contentfilter filter-name)))

(defn unregister-contentfilter [ participant-instance filter-name  ]
  (assert (instance? DomainParticipant participant-instance) (str "Argument \"participant-instance\" not an instance of class DomainParticipant: " participant-instance))
  (assert (instance? String filter-name) (str "Argument \"filter-name\" not an instance of class String: " filter-name))
  (. participant-instance (unregister_contentfilter filter-name)))

(defn get-participant-protocol-status [ participant-instance ]
  (core-util/assert-class DomainParticipant participant-instance)
  (let [status (DomainParticipantProtocolStatus.)]
    (. participant-instance (get_participant_protocol_status status))
    status))

(defn get-implicit-publisher [ participant-instance ]
  (core-util/assert-class DomainParticipant participant-instance)
  (. participant-instance (get_implicit_publisher)))

(defn get-implicit-subscriber [ participant-instance ]
  (core-util/assert-class DomainParticipant participant-instance)
  (. participant-instance (get_implicit_subscriber)))

(defn lookup-publisher-by-name [ participant-instance publisher-name ]
  (core-util/assert-class DomainParticipant participant-instance)
  (core-util/assert-class String publisher-name)
  (. participant-instance (lookup_publisher_by_name publisher-name)))

(defn lookup-subscriber-by-name [ participant-instance subscriber-name ]
  (core-util/assert-class DomainParticipant participant-instance)
  (core-util/assert-class String subscriber-name)
  (. participant-instance (lookup_subscriber_by_name subscriber-name)))

(defn lookup-datawriter-by-name [ participant-instance datawriter-full-name ]
  (core-util/assert-class DomainParticipant participant-instance)
  (core-util/assert-class String datawriter-full-name)
  (. participant-instance (lookup_datawriter_by_name datawriter-full-name)))

(defn lookup-datareader-by-name [ participant-instance datareader-full-name ]
  (core-util/assert-class DomainParticipant participant-instance)
  (core-util/assert-class String datareader-full-name)
  (. participant-instance (lookup_datareader_by_name datareader-full-name)))




;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
