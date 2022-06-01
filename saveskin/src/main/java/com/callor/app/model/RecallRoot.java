package com.callor.app.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "channel")
public class RecallRoot {

	@XmlElement(name = "return")
	RecallReturn recallReturn;

}
