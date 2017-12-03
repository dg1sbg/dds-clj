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
;;;; ==========================================================================

;;;; --------------------------------------------------------------------------
;;;;   NAMESPACE
;;;; --------------------------------------------------------------------------

(ns dds-clj.domain.participant-factory

  (:import [com.rti.dds.infrastructure

            StringSeq
           ]

           [com.rti.dds.domain

            DomainParticipantFactory
            DomainParticipantFactoryQos
            DomainParticipant
            DomainParticipantAdapter
            DomainParticipantListener
            DomainParticipantQos
           ]

           [com.rti.dds.publication

             DataWriterQos
             PublisherQos
           ]

           [com.rti.dds.subscription

             DataReaderQos
             SubscriberQos
           ]

           [com.rti.dds.topic

             TopicQos
           ]

           ))

;;;; --------------------------------------------------------------------------
;;;;   SPECIAL VARS
;;;; --------------------------------------------------------------------------

(def ^:dynamic *default-dds-domain-id* "Default DCA OMG DDS Domain ID" 71)

;;;; --------------------------------------------------------------------------
;;;;   UTIL FUNCTIONS
;;;; --------------------------------------------------------------------------


;;;; --------------------------------------------------------------------------
;;;;   WRAPPER FUNCTIONS
;;;; --------------------------------------------------------------------------

;;;; --------------------------------------------------------------------------
;;;;   DOMAIN PARTICIPANT FACTORY
;;;; --------------------------------------------------------------------------

(defn get-instance []
  (DomainParticipantFactory/get_instance))

(defn finalize-instance []
  (DomainParticipantFactory/finalize_instance))

(defn create-participant [ domain-id qos listener mask & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (create_participant domain-id qos listener mask)))

(defn delete-participant [ a-participant & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (delete_participant a-participant)))

(defn get-default-participant-qos [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (DomainParticipantQos. )]
    (. participant-factory-instance (get_default_participant_qos qos))
    qos))

(defn set-default-participant-qos [ qos & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (set_default_participant_qos qos)))

;; RTI Connext DDS Extension
(defn set-default-participant-qos-with-profile [ library-name profile-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}}]
  (. participant-factory-instance (set_default_participant_qos_with_profile library-name profile-name)))

(defn lookup-participant [ domain-id & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (lookup_participant domain-id)))

(defn get-qos [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (DomainParticipantQos. )]
    (. participant-factory-instance (get_qos qos))
    qos))

(defn set-qos [ qos & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (set_qos qos)))

;; RTI Connext DDS Extension
(defn load-profiles [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (load_profiles)))

;; RTI Connext DDS Extension
(defn reload-profiles [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (reload_profiles)))

;; RTI Connext DDS Extension
(defn unload-profiles [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (unload_profiles)))

;; RTI Connext DDS Extension
(defn get-default-library [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (get_default_library)))

;; RTI Connext DDS Extension
(defn set-default-library [ library-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (set_default_library library-name)))

;; RTI Connext DDS Extension
(defn get-default-profile [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (get_default_profile)))

;; RTI Connext DDS Extension
(defn set-default-profile [ library-name profile-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (set_default_profile library-name profile-name)))

;; RTI Connext DDS Extension
(defn get-default-profile-library [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (get_default_profile_library)))

;; RTI Connext DDS Extension
(defn get-participant-factory-qos-from-profile [ library-name profile-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (DomainParticipantFactoryQos. )]
    (. participant-factory-instance (get_participant_factory_qos_from_profile qos library-name profile-name))
    qos))

;; RTI Connext DDS Extension
(defn get-participant-qos-from-profile [ library-name profile-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (DomainParticipantQos. )]
    (. participant-factory-instance (get_participant_qos_from_profile qos library-name profile-name))
    qos))

;; RTI Connext DDS Extension
(defn get-publisher-qos-from-profile [ library-name profile-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (PublisherQos. )]
    (. participant-factory-instance (get_publisher_qos_from_profile qos library-name profile-name))
    qos))

;; RTI Connext DDS Extension
(defn get-subscriber-qos-from-profile [ library-name profile-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (SubscriberQos. )]
    (. participant-factory-instance (get_subscriber_qos_from_profile qos library-name profile-name))
    qos))

;; RTI Connext DDS Extension
(defn get-datawriter-qos-from-profile [ library-name profile-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (DataWriterQos. )]
    (. participant-factory-instance (get_datawriter_qos_from_profile qos library-name profile-name))
    qos))

;; RTI Connext DDS Extension
(defn get-datawriter-qos-from-profile-w-topic-name [ library-name profile-name topic-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (DataWriterQos. )]
    (. participant-factory-instance (get_datawriter_qos_from_profile_w_topic_name qos library-name profile-name topic-name))
    qos))

;; RTI Connext DDS Extension
(defn get-datareader-qos-from-profile [ library-name profile-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (DataReaderQos. )]
    (. participant-factory-instance (get_datareader_qos_from_profile qos library-name profile-name))
    qos))

;; RTI Connext DDS Extension
(defn get-datareader-qos-from-profile-w-topic-name [ library-name profile-name topic-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (DataReaderQos. )]
    (. participant-factory-instance (get_datareader_qos_from_profile_w_topic_name qos library-name profile-name topic-name))
    qos))

;; RTI Connext DDS Extension
(defn get-topic-qos-from-profile [ library-name profile-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (TopicQos. )]
    (. participant-factory-instance (get_topic_qos_from_profile qos library-name profile-name))
    qos))

;; RTI Connext DDS Extension
(defn get-topic-qos-from-profile-w-topic-name [ library-name profile-name topic-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ qos (TopicQos. )]
    (. participant-factory-instance (get_topic_qos_from_profile_w_topic_name qos library-name profile-name topic-name))
    qos))

;; RTI Connext DDS Extension
(defn get-qos-profile-libraries [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (let [ library-names (StringSeq. )]
    (. participant-factory-instance (get_qos_profile_libraries library-names))
    library-names))

;; RTI Connext DDS Extension
(defn create-participant-with-profile [ domain-id library-name profile-name domain-participant-listener mask & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (create_participant_with_profile domain-id library-name profile-name domain-participant-listener mask)))

;; RTI Connext DDS Extension
(defn unregister-thread [ & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (unregister_thread)))

;; RTI Connext DDS Extension
(defn create-participant-from-config [ configuration-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (create_participant_from_config configuration-name)))

;; RTI Connext DDS Extension
(defn create-participant-from-config-w-params [ configuration-name params & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (create_participant_from_config_w_params configuration-name params)))

;; RTI Connext DDS Extension
(defn lookup-participant-by-name [ participant-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (lookup_participant_by_name participant-name)))

(defn register-type-support [ type-support type-name & {:keys [participant-factory-instance] :or {participant-factory-instance (get-instance)}} ]
  (. participant-factory-instance (register_type_support type-support type-name)))

;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
