export interface UserRepo{
    data:[{
        id:any,
        name:string,
        lastName:string,
        numberWorkouts:any,
        group:string
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