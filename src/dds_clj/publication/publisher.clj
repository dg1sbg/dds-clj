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

(ns dds-clj.publication.publisher

  (:require ;;[dds-clj.domain.participant-factory :as domain-participant-factory]
            [dds-clj.core.util :as core-util])

  (:import  [com.rti.dds.infrastructure

             Duration_t
             ]

            [com.rti.dds.publication

             Publisher
             PublisherQos
             PublisherListener
             DataWriter
             DataWriterQos
             DataWriterListener
             DataWriterSeq
             ;;FlowController
            ]

            [com.rti.dds.topic

             Topic
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

(defn get-default-datawriter-qos [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (let [qos (DataWriterQos.)]
    (. publisher-instance (get_default_datawriter_qos qos))
    qos))

(defn set-default-datawriter-qos [ publisher-instance qos ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class DataWriterQos qos)
  (. publisher-instance (set_default_datawriter_qos qos)))

(defn set-default-datawriter-qos-with-profile [ publisher-instance library-name profile-name ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (. publisher-instance (set_default_datawriter_qos_with_profile library-name profile-name)))

(defn create-datawriter [ publisher-instance topic qos listener mask ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class Topic topic)
  (core-util/assert-class DataWriterQos qos)
  (when listener
    (core-util/assert-class DataWriterListener listener))
  (core-util/assert-class Integer mask)
  (. publisher-instance (create_datawriter topic qos listener mask)))

(defn create-datawriter-with-profile [ publisher-instance topic library-name profile-name listener mask ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class Topic topic)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (when listener
    (core-util/assert-class DataWriterListener listener))
  (core-util/assert-class Integer mask)
  (. publisher-instance (create_datawriter_with_profile topic library-name profile-name listener mask)))

(defn delete-datawriter [ publisher-instance datawriter ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class DataWriter datawriter)
  (. publisher-instance (delete_datawriter datawriter)))

(defn lookup-datawriter [ publisher-instance topic-name ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class String topic-name)
  (. publisher-instance (lookup_datawriter topic-name)))

(defn set-qos [ publisher-instance qos ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class PublisherQos qos)
  (. publisher-instance (set_qos qos)))

(defn set-qos-with-profile [ publisher-instance library-name profile-name ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (. publisher-instance (set_qos_with_profile library-name profile-name)))

(defn get-qos [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (let [qos (PublisherQos.)]
    (. publisher-instance (get_qos qos))
    qos))

(defn get-default-library [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (get_default_library)))

(defn set-default-library [ publisher-instance library-name ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class String library-name)
  (. publisher-instance (set_default_library library-name)))

(defn get-default-profile [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (get_default_profile)))

(defn set-default-profile [ publisher-instance library-name profile-name ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class String library-name)
  (core-util/assert-class String profile-name)
  (. publisher-instance (set_default_profile library-name profile-name)))

(defn get-default-profile-library [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (get_default_profile_library)))

(defn set-listener [ publisher-instance l mask ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class PublisherListener l)
  (core-util/assert-class Integer mask)
  (. publisher-instance (set_listener l mask)))

(defn get-listener [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (get-_listener)))

(defn suspend-publications [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (suspend_publications)))

(defn resume-publications [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (resume_publications)))

(defn begin-coherent-changes [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (begin_coherent_changes)))

(defn end-coherent-changes [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (end_coherent_changes)))

(defn copy-from-topic-qos [ publisher-instance datawriter-qos topic-qos ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class DataWriterQos datawriter-qos)
  (core-util/assert-class TopicQos topic-qos)
  (. publisher-instance (copy_from_topic_qos datawriter-qos topic-qos)))

(defn get-all-datawriters [ publisher-instance writers ]
  (core-util/assert-class Publisher publisher-instance)
  (when writers
    (core-util/assert-class DataWriterSeq writers))
  (. publisher-instance (get_all_datawriters writers)))

(defn get-participant [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (get_participant)))

(defn delete-contained-entities [ publisher-instance ]
  (core-util/assert-class Publisher publisher-instance)
  (. publisher-instance (delete_contained_entities)))

(defn wait-for-acknowledgements [ publisher-instance max-wait ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class Duration_t max-wait)
  (. publisher-instance (wait_for_acknowledgements max-wait)))

(defn wait-for-asynchronous-publishing[ publisher-instance max-wait ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class Duration_t max-wait)
  (. publisher-instance (wait_for_asynchronous_publishing max-wait)))

(defn lookup-datawriter-by-name[ publisher-instance datawriter-name ]
  (core-util/assert-class Publisher publisher-instance)
  (core-util/assert-class String datawriter-name)
  (. publisher-instance (lookup_datawriter_by_name datawriter-name)))

;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
