:- modeh(1,eastbound(+train)).
:- modeb(1,small(+car)).
:- modeb(1,large(+car)).
:- modeb(1,wheels(+car,#int)).
:- modeb(*,has_car(+train,-car)).

:- determination(eastbound/1,small/1).
:- determination(eastbound/1,large/1).
:- determination(eastbound/1,wheels/2).
:- determination(eastbound/1,has_car/2).

car(car_11). car(car_12). 
car(car_21). car(car_22). 
car(car_31). car(car_32). 
car(car_41). car(car_42). 
car(car_51). car(car_52). 
car(car_61). car(car_62). car(car_63). 
car(car_71). car(car_72). 
car(car_81). car(car_82). 
car(car_91). car(car_92). 
car(car_101). car(car_102). car(car_103). 

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

small(car_11).
small(car_12).
wheels(car_11,4).
wheels(car_12,3).
has_car(east1,car_11).
has_car(east1,car_12).

small(car_21).
small(car_22).
wheels(car_21,4).
wheels(car_22,3).
has_car(east2,car_21).
has_car(east2,car_22).

small(car_31).
small(car_32).
wheels(car_31,4).
wheels(car_32,3).
has_car(east3,car_31).
has_car(east3,car_32).

small(car_41).
small(car_42).
wheels(car_41,4).
wheels(car_42,3).
has_car(east4,car_41).
has_car(east4,car_42).

small(car_51).
large(car_52).
wheels(car_51,4).
wheels(car_52,4).
has_car(east5,car_51).
has_car(east5,car_52).

large(car_61).
small(car_62).
small(car_63).
wheels(car_61,2).
wheels(car_62,2).
wheels(car_63,4).
has_car(west6,car_61).
has_car(west6,car_62).
has_car(west6,car_63).

small(car_71).
large(car_72).
wheels(car_71,3).
wheels(car_72,2).
has_car(west7,car_71).
has_car(west7,car_72).

small(car_81).
small(car_82).
wheels(car_81,3).
wheels(car_82,4).
has_car(west8,car_81).
has_car(west8,car_82).

small(car_91).
small(car_92).
wheels(car_91,2).
wheels(car_92,4).
has_car(west9,car_91).
has_car(west9,car_92).

small(car_101).
small(car_102).
small(car_103).
wheels(car_101,2).
wheels(car_102,4).
wheels(car_103,4).
has_car(west10,car_101).
has_car(west10,car_102).
has_car(west10,car_103).

