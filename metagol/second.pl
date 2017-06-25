parent(ann,amy).
parent(amy,amelia).

prim(parent/2).

a :-
  Pos = [
    grandparent(ann,amelia)
  ],
  Neg = [
    grandparent(amy,amelia)
  ],
  learn(Pos,Neg,Prog),
  pprint(Prog).

metarule([P,Q],([P,A,B]:-[[Q,A,B]])).
metarule([P,Q,R],([P,A,B]:-[[Q,A,B],[R,A,B]])).
metarule([P,Q,R],([P,A,B]:-[[Q,A,C],[R,C,B]])).
