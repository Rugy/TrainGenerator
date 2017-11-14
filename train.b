:- modeh(1,eastbound(+train)).
:- modeb(1,small(+car)).
:- modeb(1,large(+car)).
:- modeb(1,shape(+car,#shape)).
:- modeb(1,wheels(+car,#int)).
:- modeb(*,has_car(+train,-car)).
:- modeb(*,infront(+car,-car)).
:- modeb(1,medium(+car)).

:- determination(eastbound/1,small/1).
:- determination(eastbound/1,large/1).
:- determination(eastbound/1,shape/2).
:- determination(eastbound/1,wheels/2).
:- determination(eastbound/1,has_car/2).
:- determination(eastbound/1,infront/2).
:- determination(eastbound/1,medium/1).

infront(A,C) :- infront(A,B), infront(B,C).

car(car_11). car(car_12). 
car(car_21). car(car_22). 
car(car_31). car(car_32). 
car(car_41). car(car_42). 
car(car_51). car(car_52). 
car(car_61). car(car_62). 
car(car_71). car(car_72). 
car(car_81). car(car_82). 
car(car_91). car(car_92). 
car(car_101). car(car_102). 

train(east1).
train(east2).
train(east3).
train(east4).
train(east5).
train(west6).
train(west7).
train(west8).
train(west9).
train(west10).

shape(triangle).
shape(circle).
shape(donut).
shape(heart).
shape(dash).

small(car_11).
large(car_12).
wheels(car_11,5).
wheels(car_12,3).
shape(car_11,triangle).
shape(car_12,circle).
has_car(east1,car_11).
has_car(east1,car_12).
infront(car_11,car_12).

small(car_21).
large(car_22).
wheels(car_21,3).
wheels(car_22,4).
shape(car_21,donut).
shape(car_22,circle).
has_car(east2,car_21).
has_car(east2,car_22).
infront(car_21,car_22).

medium(car_31).
large(car_32).
wheels(car_31,3).
wheels(car_32,4).
shape(car_31,donut).
shape(car_32,heart).
has_car(east3,car_31).
has_car(east3,car_32).
infront(car_31,car_32).

small(car_41).
medium(car_42).
wheels(car_41,4).
wheels(car_42,2).
shape(car_41,donut).
shape(car_42,circle).
has_car(east4,car_41).
has_car(east4,car_42).
infront(car_41,car_42).

medium(car_51).
large(car_52).
wheels(car_51,3).
wheels(car_52,4).
shape(car_51,triangle).
shape(car_52,donut).
has_car(east5,car_51).
has_car(east5,car_52).
infront(car_51,car_52).

small(car_61).
small(car_62).
wheels(car_61,5).
wheels(car_62,2).
shape(car_61,heart).
shape(car_62,triangle).
has_car(west6,car_61).
has_car(west6,car_62).
infront(car_61,car_62).

medium(car_71).
medium(car_72).
wheels(car_71,4).
wheels(car_72,3).
shape(car_71,dash).
shape(car_72,triangle).
has_car(west7,car_71).
has_car(west7,car_72).
infront(car_71,car_72).

large(car_81).
small(car_82).
wheels(car_81,3).
wheels(car_82,5).
shape(car_81,dash).
shape(car_82,dash).
has_car(west8,car_81).
has_car(west8,car_82).
infront(car_81,car_82).

medium(car_91).
medium(car_92).
wheels(car_91,2).
wheels(car_92,2).
shape(car_91,heart).
shape(car_92,donut).
has_car(west9,car_91).
has_car(west9,car_92).
infront(car_91,car_92).

medium(car_101).
small(car_102).
wheels(car_101,3).
wheels(car_102,3).
shape(car_101,circle).
shape(car_102,triangle).
has_car(west10,car_101).
has_car(west10,car_102).
infront(car_101,car_102).

