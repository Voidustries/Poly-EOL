---
layout: post
title: Download
permalink: /download/
icon: download
---

<table style="width:100%">
  <tr>
    <th>Version</th>
	<th>Codename</th>
    <th>Link</th>
  </tr>
{% for download in site.static_files %}
	{% if download.path contains 'downloads' %}
		{% case shipping_method.title %}
			{% when {% download.path contains '1.0' %}
				{% assign version = '1.0' %}
		{% endcase %}
	  <tr>
		<th>{{ version }}</th>
		<th>{{ download.basename }}</th>
		<th><a href='{{ site.baseurl }}{{ download.path }}'>Here</a></th>
	  </tr>
	 {% endif %}
{% endfor %}
