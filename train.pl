:- use_module('aleph/aleph').

ind :-
	aleph:read_all('train'),
	aleph:set(verbosity,1),
  aleph:set(clauselength,10),
  aleph:set(minacc,0.6),
  aleph:set(minscore,3),
  aleph:set(minpos,3),
  aleph:set(noise,5),
  aleph:set(nodes,5000),
  aleph:set(explore,true),
  aleph:set(max_features,20000),
	%aleph:set(search,rls),
	%aleph:set(rls_type,rrr),
	aleph:set(rulefile,'rulefile.txt'),
	%aleph:set(samplesize,4),
  %aleph:set(resample,4),
  %aleph:set(permute_bottom,true),
  %aleph:set(nreduce_bottom,true),
  %aleph:set(search,false),
	%aleph:set(record,true),
	%aleph:set(recordfile,'recordfile.txt'),
	%aleph:set(good,true),
	%aleph:set(goodfile,'goodfile.txt'),
	aleph:induce,
	aleph:write_rules.