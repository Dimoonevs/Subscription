export interface UserRepo{
    data:[{
        id:any,
        name:string,
        lastName:string,
        numberWorkouts:any
    }]
}
export interface GetSportsmenByIDResp{
    data: {
        name:string,
        lastName:string,
        numberWorkouts:any,
        group:any
    }
}
export interface UpdateSportsmanReq{
    name:string,
    lastName:string,
    numberWorkouts:any,
    group:any
}
export interface AddNewSportsmen{
    name:string,
    lastName:string,
    numberWorkouts:any,
    group:any
}
export interface Couach{
    login: string,
    password: string
}
export interface CouachReq{
   token: string 
}
export interface AuthResp{
    data : string
}
export interface GropeReq{
    grope: string 
}
export enum Groups{
    LITTLE_GROUP,
    BEGINNERS_GROUP,
    OLDER_GROUP
}
export interface GroupsFreezedUnfreezedTrainingResp{
    data: {
        trainingIsFreezeAll: boolean;
        trainingIsFreezeLittle: boolean;
        trainingIsFreezeBeginner: boolean;
        trainingIsFreezeOlder: boolean;
    }
}