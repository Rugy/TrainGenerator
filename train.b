:- modeh(1,eastbound(+train)).
:- modeb(1,small(+car)).
:- modeb(1,large(+car)).
:- modeb(1,wheels(+car,#int)).
:- modeb(*,has_car(+train,-car)).

:- determination(eastbound/1,small/1).
:- determination(eastbound/1,large/1).
:- determination(eastbound/1,wheels/2).
:- determination(eastbound/1,has_car/2).

car(car_11). car(car_12). car(car_13). car(car_14). car(car_15). 
car(car_21). car(car_22). car(car_23). car(car_24). 
car(car_31). car(car_32). car(car_33). car(car_34). 
car(car_41). car(car_42). car(car_43). car(car_44). 
car(car_51). car(car_52). car(car_53). car(car_54). car(car_55). 
car(car_61). car(car_62). car(car_63). car(car_64). 
car(car_71). car(car_72). car(car_73). car(car_74). car(car_75). 
car(car_81). car(car_82). car(car_83). car(car_84). car(car_85). 
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

large(car_11).
small(car_12).
large(car_13).
large(car_14).
large(car_15).
wheels(car_11,2).
wheels(car_12,4).
wheels(car_13,2).
wheels(car_14,3).
wheels(car_15,3).
has_car(east1,car_11).
has_car(east1,car_12).
has_car(east1,car_13).
has_car(east1,car_14).
has_car(east1,car_15).

large(car_21).
small(car_22).
small(car_23).
small(car_24).
wheels(car_21,2).
wheels(car_22,4).
wheels(car_23,4).
wheels(car_24,2).
has_car(east2,car_21).
has_car(east2,car_22).
has_car(east2,car_23).
has_car(east2,car_24).

large(car_31).
small(car_32).
large(car_33).
small(car_34).
wheels(car_31,2).
wheels(car_32,4).
wheels(car_33,2).
wheels(car_34,4).
has_car(east3,car_31).
has_car(east3,car_32).
has_car(east3,car_33).
has_car(east3,car_34).

large(car_41).
small(car_42).
small(car_43).
small(car_44).
wheels(car_41,2).
wheels(car_42,4).
wheels(car_43,2).
wheels(car_44,3).
has_car(east4,car_41).
has_car(east4,car_42).
has_car(east4,car_43).
has_car(east4,car_44).

large(car_51).
small(car_52).
large(car_53).
small(car_54).
large(car_55).
wheels(car_51,2).
wheels(car_52,4).
wheels(car_53,4).
wheels(car_54,4).
wheels(car_55,3).
has_car(east5,car_51).
has_car(east5,car_52).
has_car(east5,car_53).
has_car(east5,car_54).
has_car(east5,car_55).

large(car_61).
large(car_62).
large(car_63).
small(car_64).
wheels(car_61,3).
wheels(car_62,2).
wheels(car_63,3).
wheels(car_64,2).
has_car(west6,car_61).
has_car(west6,car_62).
has_car(west6,car_63).
has_car(west6,car_64).

large(car_71).
small(car_72).
small(car_73).
small(car_74).
large(car_75).
wheels(car_71,4).
wheels(car_72,3).
wheels(car_73,4).
wheels(car_74,4).
wheels(car_75,3).
has_car(west7,car_71).
has_car(west7,car_72).
has_car(west7,car_73).
has_car(west7,car_74).
has_car(west7,car_75).

large(car_81).
small(car_82).
small(car_83).
small(car_84).
small(car_85).
wheels(car_81,2).
wheels(car_82,2).
wheels(car_83,3).
wheels(car_84,2).
wheels(car_85,4).
has_car(west8,car_81).
has_car(west8,car_82).
has_car(west8,car_83).
has_car(west8,car_84).
has_car(west8,car_85).

small(car_91).
large(car_92).
wheels(car_91,3).
wheels(car_92,4).
has_car(west9,car_91).
has_car(west9,car_92).

small(car_101).
large(car_102).
small(car_103).
wheels(car_101,3).
wheels(car_102,3).
wheels(car_103,3).
has_car(west10,car_101).
has_car(west10,car_102).
has_car(west10,car_103).

