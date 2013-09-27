package com.amebame.triton.client.cassandra.method;

public enum Consistency {

	all,
	any,
	each_quorum,
	local_quorum,
	quorum,
	one,
	two,
	three
	;
	
}
