gwt-garmin-api
==============

GWT implementation allowing access to Garmin running watch API's

While the existing JS Communicator Plugin API is extensive, this library seeks to only expose:
* Ability to detect a device
* Ability to read tracks/points from a device
* Ability to write tracks/points to a device

Additional features meant assist in the parsing of XML, files, and display of buttons, lists and maps can be achieved with various other libraries, and as such is not in the initial purview of this library.

Disclaimer
==========

Garmin is a trademark of Garmin Ltd. This library is **NOT** afiliated in any way with Garmin Ltd.

Official API Docs
=================
See [Garmin Docs](http://developer.garmin.com/web/communicator-api/documentation/)


Just Started
============

I'm starting this to have an easy way to access Garmin watch data clientside. I'm in the research stage to determine if other GPS watch vendors have web API's, but Polar, Soleus, Timex and Nike are all closed source OS specifc binaries. None offer browser plugins but Garmin, so Garmin it is for the time being.
