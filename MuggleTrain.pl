% Stephen Muggleton's Prolog code for
% randomly generating Michalski trains.
% To run this you need a Prolog interpreter which executes
% a goal of the form:
% R is random
% Otherwise replace the definition of random/2 appropriately.
% (R is random binds R to a pseudo-random number floating
% point between 0 and 1.)
% The top-level predicates are trains/0 and trains/1.

% modified for SWI-Prolog (threaded, 32 bits, version 7.4.2) by Andreas Heimann

:- dynamic counter/1.
counter(0).

trains :-
	repeat,
	train1(X), show(X),
	write('More (y/n)? '),
	read(n).
trains([]) :- !.
trains([H|T]) :- train1(H), trains(T), !.

% Rule
eastbound(T) :- 
	findall(A,(has_car(T,A)), L),
	has_car(T,B),
	has_car(T,C),
	(short(B),
	medium(C));
	(short(B),
	long(C));
	(medium(B),
	long(C)),
	infront(T,B,C).

train1(Carriages) :-
	random([0.1,0.4,0.25,0.25],NCarriages),
	length(Carriages,NCarriages),
	carriages(Carriages,1), !.

carriages([],_).
carriages([C|Cs],N) :-
	carriage(C,N), N1 is N+1,
	carriages(Cs,N1), !.
	
carriage(c(N,Shape,Length,Double,Roof,Wheels,Load),N) :-
	randprop(car_length,[0.3,0.4,0.3],Length),
	shape(Length,Shape),
	double(Length,Shape,Double),
	roof1(Length,Shape,Roof),
	wheels(Length,Wheels),
	load(Length,Load), !.
	
shape(long,rectangle).
shape(medium,S) :-
	randprop(car_shape,[0.1,0.1,0.1,0.3,0.4],S).
shape(short,S) :-
	randprop(car_shape,[0.048,0.048,0.524,0.190,0.190],S).
	
double(short,rectangle,Double) :-
	randprop(car_double,[0.55,0.45],Double), !.
double(_,_,not_double) :- !.

roof1(short,ellipse,arc) :- !.
roof1(short,hexagon,flat) :- !.
roof1(short,_,R) :- randprop(roof_shape,[0.842,0.105,0,0.053,0],R).
roof1(medium,u_shaped,arc) :- !.
roof1(medium,_,R) :- randprop(roof_shape,[0.5,0.4,0.05,0.05,0],R).
roof1(long,_,R) :- randprop(roof_shape,[0.333,0.444,0.223,0,0],R).

wheels(short,2).
wheels(medium,W) :- random([0.2,0.6,0.2],W).
wheels(long,W) :- random([0,0.56,0.44],W).

load(short,l(Shape,N)) :-
	randprop(load_shape,[0.381,0.048,0,0.190,0.381,0],Shape),
	random([0.952,0.048],N).
load(medium,l(Shape,N)) :-
	randprop(load_shape,[0.381,0.048,0,0.190,0.381,0],Shape),
	random([0.952,0.048],N).
load(long,l(Shape,N)) :-
	randprop(load_shape,[0.125,0,0.125,0.625,0,0.125],Shape),
	random([0.11,0.55,0.11,0.23],N1), N is N1-1.
	
random(Dist,N) :-
	random(R),
	random(1,0,R,Dist,N).

random(N,_,_,[_],N).
random(N,P0,R,[P|_],N) :-
	P1 is P+P0, R=<P1, !.
random(N,P0,R,[P|Rest],M) :-
	P1 is P+P0, 
	N1 is N+1,
	random(N1,P1,R,Rest,M), !.
	
randprop(Prop,Dist,Value) :-
	random(Dist,R),
	Call=..[Prop,R,Value],
	Call, !.
	
car_shape(1,ellipse). car_shape(2,hexagon).
car_shape(3,rectangle). car_shape(4,u_shaped). car_shape(5,bucket).
car_length(1,short). car_length(2,medium). car_length(3,long).
car_open(1,open). car_open(2,closed).
car_double(1,not_double). car_double(2,double).
roof_shape(1,none). roof_shape(2,flat). roof_shape(3,jagged).
roof_shape(4,peaked). roof_shape(5,arc).
load_shape(1,circle). load_shape(2,diamond). load_shape(3,hexagon).
load_shape(4,rectangle). load_shape(5,triangle). load_shape(6,utriangle).

show(Train) :-
	nl,
	(eastbound(Train) -> (write('Eastbound train:'), nl, printTrain(Train))
	;otherwise -> (write('Westbound train:'),nl)),
	show0(Train), nl, !.
show0([]).
show0([C|Cs]) :-
	C=c(N,Shape,Length,Double,Roof,Wheels,l(Lshape,Lno)),
	format("~w ~s ~s ~s ~s ~w ~s ~w ~n", [N,Shape,Length,Double,Roof,Wheels,Lshape,Lno]),
	show0(Cs), !.
	
printTrain(Train) :-
	counter(Count),
	retractall(counter(_)),
	succ(Count,Next),
	assertz(counter(Next)),
	open('MuggleTrains.txt',append,OS),
	format(OS,"train(east~w).~n",[Count]),
	close(OS),
	printCars(Train).
	
printCars([]).
printCars(Train) :-
	counter(Count),
	Train=[C|Cs],
	C=c(N,_,Length,_,_,_,_),
	open('MuggleTrains.txt',append,OS),
	format(OS,"car(car_~w~w).~n~s(car_~w~w).~n",[Count,N,Length,Count,N]),
	close(OS),
	printInFront(Train),
	printCars(Cs).
	
printInFront([]).
printInFront(Train) :-
	counter(Count),
	length(Train,X),
	X>=2,
	Train=[C1,C2|_],
	C1=c(N1,_,_,_,_,_,_),
	C2=c(N2,_,_,_,_,_,_),
	open('MuggleTrains.txt',append,OS),
	format(OS,"infront(car_~w~w,car_~w~w).~n",[Count,N1,Count,N2]),
	close(OS).
printInFront(_).
	
	
% writes([]).
% writes([H|T]) :-
% mywrite(H),
% writes(T).

mywrite(nl) :- nl, !.
mywrite(tab(X)) :- tab(X), !.
mywrite(X) :- write(X), !.

% Concept tester below emulates Michalski predicates.

has_car(T,C) :- member(C,T).

infront(T,C1,C2) :- append(_,[C1,C2|_],T).

ellipse(C) :- arg(2,C,ellipse). hexagon(C) :- arg(2,C,hexagon).
rectangle(C) :- arg(2,C,rectangle). u_shaped(C) :- arg(2,C,u_shaped).
bucket(C) :- arg(2,C,bucket).

long(C) :- arg(3,C,long). medium(C) :- arg(3,C,medium). short(C) :- arg(3,C,short).

double(C) :- arg(4,C,double).

has_roof(C,r(R,N)) :- arg(1,C,N), arg(5,C,R).

open(C) :- arg(5,C,none).
closed(C) :- not(open(C)).

has_wheel(C,w(NC,W)) :- arg(1,C,NC), arg(6,C,NW), nlist(1,NW,L), member(W,L).

has_load(C,Load) :- arg(7,C,l(_,NLoad)), nlist(1,NLoad,L), member(Load,L).

has_load0(C,Shape) :- arg(7,C,l(Shape,N)), 1=<N.

has_load1(T,Shape) :- has_car(T,C), has_load0(C,Shape).

none(r(none,_)). flat(r(flat,_)).
jagged(r(jagged,_)). peaked(r(peaked,_)).
arc(r(arc,_)).

member(X,[X|_]).
member(X,[_|T]) :- member(X,T).

nlist(N,N,[N]) :- !.
nlist(M,N,[M|T]) :-
	M=<N,
	M1 is M+1, nlist(M1,N,T), !.
	
len1([],0) :- !.
len1([_|T],N) :- 
	len1(T,N1), 
	N is N1+1, !.

append([],L,L) :- !.
append([H|L1],L2,[H|L3]) :-
	append(L1,L2,L3), !.