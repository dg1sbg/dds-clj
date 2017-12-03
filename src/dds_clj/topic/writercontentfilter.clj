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
;;;;   WRAPPER FOR:  COM:RTI.DDS.TOPIC.WRITERCOMNTENTFILTER
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

(ns dds-clj.topic.writercontentfilter

  (:require [dds-clj.core.util :as core-util])

  (:import [com.rti.dds.infrastructure

            ObjectHolder
            StringSeq
            Cookie_t
           ]

           [com.rti.dds.topic

            WriterContentFilter
            ExpressionProperty
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

(defn writer-attach [ writercontentfilter-instance]
  (core-util/assert-class WriterContentFilter writercontentfilter-instance)
  (let [writer-filter-data (ObjectHolder.)]
    (. writercontentfilter-instance (writer_attach writer-filter-data))
    writer-filter-data))

(defn writer-detach [ writercontentfilter-instance writer-filter-data]
  (core-util/assert-class WriterContentFilter writercontentfilter-instance)
  (core-util/assert-class Object writer-filter-data)
  (. writercontentfilter-instance (writer_detach writer-filter-data)))

(defn writer-compile [ writercontentfilter-instance writer-filter-data
                      prop expression parameters type-code type-class-name
                      cookie ]
  (core-util/assert-class WriterContentFilter writercontentfilter-instance)
  (core-util/assert-class ExpressionProperty prop)
  (core-util/assert-class String expression)
  (core-util/assert-class StringSeq parameters)
  (core-util/assert-class String type-class-name)
  (core-util/assert-class Cookie_t cookie)
  (. writercontentfilter-instance (writer_compile writer-filter-data prop expression parameters nil type-class-name cookie)))

(defn writer-evaluate [ writercontentfilter-instance writer-filter-data sample meta-data ]
  (core-util/assert-class WriterContentFilter writercontentfilter-instance)
  (core-util/assert-class Object writer-filter-data)
  (core-util/assert-class Object sample)
  (core-util/assert-class FilterSampleInfo meta-data)
  (. writercontentfilter-instance (writer_evaluate writer-filter-data sample meta-data)))

(defn writer-finalize [ writercontentfilter-instance writer-filter-data cookie]
  (core-util/assert-class WriterContentFilter writercontentfilter-instance)
  (core-util/assert-class Object writer-filter-data)
  (core-util/assert-class Cookie_t cookie)
  (. writercontentfilter-instance (writer_finalize writer-filter-data cookie)))

;;;; --------------------------------------------------------------------------
;;;;   END OF FILE
;;;; --------------------------------------------------------------------------
