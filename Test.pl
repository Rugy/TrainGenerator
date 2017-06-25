:- modeh(1,eastbound(+train)).
:- modeb(1,small(+car)).
:- modeb(1,large(+car)).
:- modeb(*,has_car(+train,-car)).

:- determination(eastboud/1,small/1).
:- determination(eastboud/1,large/1).
:- determination(eastboud/1,has_car/2).

car(car_71). car(car_72). car(car_73). car(car_74). 
car(car_51). car(car_52). car(car_53). car(car_54). car(car_55). 
car(car_41). car(car_42). car(car_43). car(car_44). car(car_45). 
car(car_21). car(car_22). car(car_23). car(car_24). car(car_25). 
car(car_11). car(car_12). 
car(car_31). car(car_32). car(car_33). 
car(car_61). car(car_62). 
car(car_81). car(car_82). car(car_83). car(car_84). 
car(car_91). car(car_92). car(car_93). car(car_94). 
car(car_101). car(car_102). car(car_103). 

train(train7).
train(train5).
train(train4).
train(train2).
train(train1).
train(train3).
train(train6).
train(train8).
train(train9).
train(train10).

% This Train is eastbound
% This Train has 4 Wagons
Wagon 0 is car_71
Wagon 1 is car_72
Wagon 2 is car_73
Wagon 3 is car_74

% This Train is eastbound
% This Train has 5 Wagons
Wagon 0 is car_51
Wagon 1 is car_52
Wagon 2 is car_53
Wagon 3 is car_54
Wagon 4 is car_55

% This Train is eastbound
% This Train has 5 Wagons
Wagon 0 is car_41
Wagon 1 is car_42
Wagon 2 is car_43
Wagon 3 is car_44
Wagon 4 is car_45

% This Train is eastbound
% This Train has 5 Wagons
Wagon 0 is car_21
Wagon 1 is car_22
Wagon 2 is car_23
Wagon 3 is car_24
Wagon 4 is car_25

% This train is westbound
% This Train has 2 Wagons
Wagon 0 is car_11
Wagon 1 is car_12

% This train is westbound
% This Train has 3 Wagons
Wagon 0 is car_31
Wagon 1 is car_32
Wagon 2 is car_33

% This train is westbound
% This Train has 2 Wagons
Wagon 0 is car_61
Wagon 1 is car_62

% This train is westbound
% This Train has 4 Wagons
Wagon 0 is car_81
Wagon 1 is car_82
Wagon 2 is car_83
Wagon 3 is car_84

% This train is westbound
% This Train has 4 Wagons
Wagon 0 is car_91
Wagon 1 is car_92
Wagon 2 is car_93
Wagon 3 is car_94

% This train is westbound
% This Train has 3 Wagons
Wagon 0 is car_101
Wagon 1 is car_102
Wagon 2 is car_103


