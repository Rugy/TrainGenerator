:- modeh(1,eastbound(+train)).
:- modeb(1,small(+car)).
:- modeb(1,large(+car)).
:- modeb(*,has_car(+train,-car)).

:- determination(eastbound/1,small/1).
:- determination(eastbound/1,large/1).
:- determination(eastbound/1,has_car/2).

car(car_11). car(car_12). car(car_13). car(car_14). car(car_15). 
car(car_21). car(car_22). car(car_23). car(car_24). 
car(car_31). car(car_32). car(car_33). car(car_34). car(car_35). 
car(car_41). car(car_42). car(car_43). car(car_44). 
car(car_51). car(car_52). car(car_53). car(car_54). car(car_55). 
car(car_61). car(car_62). car(car_63). car(car_64). car(car_65). 
car(car_71). car(car_72). car(car_73). car(car_74). 
car(car_81). car(car_82). 
car(car_91). car(car_92). car(car_93). car(car_94). 
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

has_car(east1,car_11).
has_car(east1,car_12).
has_car(east1,car_13).
has_car(east1,car_14).
has_car(east1,car_15).
large(car_12).
large(car_13).
large(car_14).
small(car_11).
small(car_15).

has_car(east2,car_21).
has_car(east2,car_22).
has_car(east2,car_23).
has_car(east2,car_24).
large(car_22).
large(car_23).
large(car_24).
small(car_21).

has_car(east3,car_31).
has_car(east3,car_32).
has_car(east3,car_33).
has_car(east3,car_34).
has_car(east3,car_35).
large(car_32).
large(car_33).
large(car_34).
small(car_31).
small(car_35).

has_car(east4,car_41).
has_car(east4,car_42).
has_car(east4,car_43).
has_car(east4,car_44).
large(car_42).
large(car_43).
large(car_44).
small(car_41).

has_car(east5,car_51).
has_car(east5,car_52).
has_car(east5,car_53).
has_car(east5,car_54).
has_car(east5,car_55).
large(car_52).
large(car_53).
large(car_54).
large(car_55).
small(car_51).

has_car(west6,car_61).
has_car(west6,car_62).
has_car(west6,car_63).
has_car(west6,car_64).
has_car(west6,car_65).
large(car_61).
large(car_62).
large(car_65).
small(car_63).
small(car_64).

has_car(west7,car_71).
has_car(west7,car_72).
has_car(west7,car_73).
has_car(west7,car_74).
large(car_73).
small(car_71).
small(car_72).
small(car_74).

has_car(west8,car_81).
has_car(west8,car_82).
large(car_81).
large(car_82).

has_car(west9,car_91).
has_car(west9,car_92).
has_car(west9,car_93).
has_car(west9,car_94).
large(car_91).
large(car_92).
large(car_93).
small(car_94).

has_car(west10,car_101).
has_car(west10,car_102).
large(car_101).
small(car_102).

