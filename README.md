# <img src="https://github.com/dg1sbg/cellar/raw/X.01.00/root-cellar.jpg"/>  THE CELLAR LIBRARY

<p><h2><b>Gönninger B&T's DDS Clojure Wrapper Library for RTI Connext DDS</b></h2>

## NOTE:  June 3, 2017 - This contains pre-release X.01.00 of Cellar version A.01.00.

## What Is This?
DDS-CLJ is a wrapper around the RTI Connext DDS Java API. This library provides a thin layer of functions to ensure safe usage of the RTI Connext DDS Java API. It exposes the functionality as Clojure functions.

It provides (not a complete list):

* Assertions to check for valid parameters in function calls to ensure safe calls to the underlying Java API
*
* Most of the functions described in the book On Lisp by Paul Graham
* An implementation of Finite State Machines

and much more 😉 - you are invited to explore ...

## Latest Release
The upcoming release is [TRIANGULUM - CELLAR X.01.00](https://github.com/dg1sbg/cellar/releases/tag/CELLAR_PREREL_X0100). See the [changes](https://github.com/dg1sbg/cellar/milestone/1) for this release.

## Dependencies: Required external packages and libraries
DDSA-CLJ builds on the following packages and libraries:

* [RTI Connext DDS Java](https://community.rti.com/documentation)
(You need to install RTI Connext DDS Java Libraries and then use our mvn-deploy-rti.sh script to make the Java libs available in your Maven repository!)

* [Clojure](https://clojure.org)

* [cider/cider-nrepl "0.16.0-SNAPSHOT"](https://github.com/clojure-emacs/cider-nrepl)
* [clojure-complete "0.2.4"](https://clojars.org/clojure-complete)
* [org.tcrawley/dynapath "0.2.5"](https://clojars.org/org.tcrawley/dynapath)

## License
<a rel="license" href="http://creativecommons.org/licenses/by-nc/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc/4.0/88x31.png" /></a><br />CELLAR is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc/4.0/">Creative Commons Attribution-NonCommercial 4.0 International License</a>. Any violation of this license will be prosecuted. German law applies in all cases and under all circumstances.

## Reporting Problems
Generally you can report problems in two fashions, either by [opening an issue ticket](https://github.com/dg1sbg/cellar/issues/new) or by [emailing to CELLAR support](mailto:cellar-support@goenninger.net). In both cases, though, you should have the following pieces handy in order for us to be able to help you out as quickly and painlessly as possible:

* Your operating system name and version.
* The branch of DDS-CLJ that you're using.
* A paste of the build log or failure point that you reached.
* Patience.

## Contact
You may contact us via email at [info@goenninger.net](mailto:info@goenninger.net) or via our website [www.goenninger.net](https://www.goenninger.net). See also [frgo's blog](http://ham-and-eggs-from-frgo.blogspot.de) for an occasional post about DDS-CLJ.
