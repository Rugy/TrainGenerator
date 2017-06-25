:- modeh(1,eastbound(+train)).
:- modeb(1,small(+car)).
:- modeb(1,large(+car)).
:- modeb(*,has_car(+train,-car)).

:- determination(eastboud/1,small/1).
:- determination(eastboud/1,large/1).
:- determination(eastboud/1,has_car/2).

car(car_101). car(car_102). car(car_103). 
car(car_81). car(car_82). car(car_83). car(car_84). car(car_85). 
car(car_61). car(car_62). car(car_63). 
car(car_41). car(car_42). car(car_43). 
car(car_11). car(car_12). car(car_13). 
car(car_21). car(car_22). car(car_23). car(car_24). 
car(car_31). car(car_32). 
car(car_51). car(car_52). 
car(car_71). car(car_72). car(car_73). car(car_74). 
car(car_91). car(car_92). 

train(train10).
train(train8).
train(train6).
train(train4).
train(train1).
train(train2).
train(train3).
train(train5).
train(train7).
train(train9).

large(car_101).
large(car_102).
small(car_103).
has_car(train10,car_101).
has_car(train10,car_102).
has_car(train10,car_103).

large(car_81).
large(car_82).
small(car_83).
large(car_84).
large(car_85).
has_car(train8,car_81).
has_car(train8,car_82).
has_car(train8,car_83).
has_car(train8,car_84).
has_car(train8,car_85).

large(car_61).
small(car_62).
small(car_63).
has_car(train6,car_61).
has_car(train6,car_62).
has_car(train6,car_63).

large(car_41).
large(car_42).
small(car_43).
has_car(train4,car_41).
has_car(train4,car_42).
has_car(train4,car_43).

large(car_11).
small(car_12).
large(car_13).
has_car(train1,car_11).
has_car(train1,car_12).
has_car(train1,car_13).

small(car_21).
small(car_22).
large(car_23).
large(car_24).
has_car(train2,car_21).
has_car(train2,car_22).
has_car(train2,car_23).
has_car(train2,car_24).

large(car_31).
small(car_32).
has_car(train3,car_31).
has_car(train3,car_32).

small(car_51).
large(car_52).
has_car(train5,car_51).
has_car(train5,car_52).

small(car_71).
large(car_72).
small(car_73).
small(car_74).
has_car(train7,car_71).
has_car(train7,car_72).
has_car(train7,car_73).
has_car(train7,car_74).

small(car_91).
large(car_92).
has_car(train9,car_91).
has_car(train9,car_92).

