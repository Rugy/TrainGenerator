:- modeb(1,eastbound(+train)).
:- modeb(1,small(+car)).
:- modeb(1,large(+car)).
:- modeb(*,has_car(+train,-car)).

:- determination(eastbound/1,small/1).
:- determination(eastbound/1,large/1).
:- determination(eastbound/1,has_car/2).

car(car_131). car(car_132). car(car_133). car(car_134). car(car_135). 
car(car_101). car(car_102). car(car_103). 
car(car_61). car(car_62). car(car_63). 
car(car_51). car(car_52). car(car_53). car(car_54). car(car_55). 
car(car_31). car(car_32). car(car_33). car(car_34). car(car_35). 
car(car_11). car(car_12). car(car_13). car(car_14). 
car(car_21). car(car_22). car(car_23). 
car(car_41). car(car_42). car(car_43). car(car_44). car(car_45). 
car(car_71). car(car_72). car(car_73). car(car_74). 
car(car_81). car(car_82). 
car(car_91). car(car_92). car(car_93). car(car_94). 
car(car_111). car(car_112). car(car_113). car(car_114). 
car(car_121). car(car_122). car(car_123). 
car(car_141). car(car_142). 
car(car_151). car(car_152). car(car_153). car(car_154). 
car(car_161). car(car_162). 
car(car_171). car(car_172). car(car_173). car(car_174). 
car(car_181). car(car_182). 
car(car_191). car(car_192). car(car_193). 
car(car_201). car(car_202). car(car_203). 

train(train13).
train(train10).
train(train6).
train(train5).
train(train3).
train(train1).
train(train2).
train(train4).
train(train7).
train(train8).
train(train9).
train(train11).
train(train12).
train(train14).
train(train15).
train(train16).
train(train17).
train(train18).
train(train19).
train(train20).

large(car_131).
large(car_132).
large(car_133).
small(car_134).
large(car_135).
has_car(train13,car_131).
has_car(train13,car_132).
has_car(train13,car_133).
has_car(train13,car_134).
has_car(train13,car_135).

large(car_101).
small(car_102).
large(car_103).
has_car(train10,car_101).
has_car(train10,car_102).
has_car(train10,car_103).

large(car_61).
large(car_62).
small(car_63).
has_car(train6,car_61).
has_car(train6,car_62).
has_car(train6,car_63).

large(car_51).
large(car_52).
large(car_53).
large(car_54).
large(car_55).
has_car(train5,car_51).
has_car(train5,car_52).
has_car(train5,car_53).
has_car(train5,car_54).
has_car(train5,car_55).

large(car_31).
small(car_32).
small(car_33).
small(car_34).
small(car_35).
has_car(train3,car_31).
has_car(train3,car_32).
has_car(train3,car_33).
has_car(train3,car_34).
has_car(train3,car_35).

large(car_11).
small(car_12).
large(car_13).
large(car_14).
has_car(train1,car_11).
has_car(train1,car_12).
has_car(train1,car_13).
has_car(train1,car_14).

small(car_21).
small(car_22).
small(car_23).
has_car(train2,car_21).
has_car(train2,car_22).
has_car(train2,car_23).

small(car_41).
large(car_42).
large(car_43).
large(car_44).
small(car_45).
has_car(train4,car_41).
has_car(train4,car_42).
has_car(train4,car_43).
has_car(train4,car_44).
has_car(train4,car_45).

small(car_71).
small(car_72).
small(car_73).
small(car_74).
has_car(train7,car_71).
has_car(train7,car_72).
has_car(train7,car_73).
has_car(train7,car_74).

small(car_81).
small(car_82).
has_car(train8,car_81).
has_car(train8,car_82).

small(car_91).
large(car_92).
large(car_93).
large(car_94).
has_car(train9,car_91).
has_car(train9,car_92).
has_car(train9,car_93).
has_car(train9,car_94).

small(car_111).
small(car_112).
small(car_113).
small(car_114).
has_car(train11,car_111).
has_car(train11,car_112).
has_car(train11,car_113).
has_car(train11,car_114).

small(car_121).
large(car_122).
large(car_123).
has_car(train12,car_121).
has_car(train12,car_122).
has_car(train12,car_123).

large(car_141).
small(car_142).
has_car(train14,car_141).
has_car(train14,car_142).

small(car_151).
small(car_152).
small(car_153).
large(car_154).
has_car(train15,car_151).
has_car(train15,car_152).
has_car(train15,car_153).
has_car(train15,car_154).

large(car_161).
large(car_162).
has_car(train16,car_161).
has_car(train16,car_162).

small(car_171).
small(car_172).
small(car_173).
small(car_174).
has_car(train17,car_171).
has_car(train17,car_172).
has_car(train17,car_173).
has_car(train17,car_174).

small(car_181).
small(car_182).
has_car(train18,car_181).
has_car(train18,car_182).

small(car_191).
small(car_192).
small(car_193).
has_car(train19,car_191).
has_car(train19,car_192).
has_car(train19,car_193).

small(car_201).
small(car_202).
small(car_203).
has_car(train20,car_201).
has_car(train20,car_202).
has_car(train20,car_203).

