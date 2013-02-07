[![Build Status](https://buildhive.cloudbees.com/job/lauflabs/job/gwt-garmin-api/badge/icon)](https://buildhive.cloudbees.com/job/lauflabs/job/gwt-garmin-api/)

gwt-garmin-api
==============

GWT implementation allowing access to Garmin running watch API's

While the existing JS Communicator Plugin API is extensive, this library seeks to only expose:
* Ability to detect a device
* Ability to read tracks/points from a device
* Ability to write tracks/points to a device

Additional features meant to assist in the parsing of XML, files, and display of buttons, lists and maps can be achieved with various other libraries, and are beyond the purview of this library.

Tested with:
* Forerunner
* Nüvi
* Edge

Demo
====
Visit the **[Live Showcase](http://lauflabs.github.com/gwt-garmin-api/showcase/)** to instantly testdrive the API with your device


Getting Started
===============
See [Getting Started Doc](https://github.com/lauflabs/gwt-garmin-api/wiki/Getting-Started)
Explore the [JavaDocs](http://lauflabs.github.com/gwt-garmin-api/javadoc/snapshot/) for minutiae

Disclaimer
==========

Garmin is a trademark of Garmin Ltd. This library is **NOT** affiliated in any way with Garmin Ltd.

Official API Docs
=================
* See [Garmin Docs](http://developer.garmin.com/web/communicator-api/documentation/)
* See Garmin [reference JS implementation](http://developer.garmin.com/web/communicator-api/documentation/symbols/src/)


Just Started
============

I'm starting this to have an easy way to access Garmin watch data clientside. I'm in the research stage to determine if other GPS watch vendors have web API's, but Polar, Soleus, Timex and Nike are all closed source OS specifc binaries. None offer browser plugins but Garmin, so Garmin it is for the time being.
