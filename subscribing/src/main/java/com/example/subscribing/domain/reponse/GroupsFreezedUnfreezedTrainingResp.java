package com.example.subscribing.domain.reponse;

public class GroupsFreezedUnfreezedTrainingResp {
    private boolean trainingIsFreezeAll;
    private boolean trainingIsFreezeLittle;
    private boolean trainingIsFreezeBeginner;
    private boolean trainingIsFreezeOlder;

    public GroupsFreezedUnfreezedTrainingResp() {
    }

    public GroupsFreezedUnfreezedTrainingResp(boolean trainingIsFreezeAll, boolean trainingIsFreezeLittle, boolean trainingIsFreezeBeginner, boolean trainingIsFreezeOlder) {
        this.trainingIsFreezeAll = trainingIsFreezeAll;
        this.trainingIsFreezeLittle = trainingIsFreezeLittle;
        this.trainingIsFreezeBeginner = trainingIsFreezeBeginner;
        this.trainingIsFreezeOlder = trainingIsFreezeOlder;
    }

    public boolean isTrainingIsFreezeAll() {
        return trainingIsFreezeAll;
    }

    public void setTrainingIsFreezeAll(boolean trainingIsFreezeAll) {
        this.trainingIsFreezeAll = trainingIsFreezeAll;
    }

    public boolean isTrainingIsFreezeLittle() {
        return trainingIsFreezeLittle;
    }

    public void setTrainingIsFreezeLittle(boolean trainingIsFreezeLittle) {
        this.trainingIsFreezeLittle = trainingIsFreezeLittle;
    }

    public boolean isTrainingIsFreezeBeginner() {
        return trainingIsFreezeBeginner;
    }

    public void setTrainingIsFreezeBeginner(boolean trainingIsFreezeBeginner) {
        this.trainingIsFreezeBeginner = trainingIsFreezeBeginner;
    }

    public boolean isTrainingIsFreezeOlder() {
        return trainingIsFreezeOlder;
    }

    public void setTrainingIsFreezeOlder(boolean trainingIsFreezeOlder) {
        this.trainingIsFreezeOlder = trainingIsFreezeOlder;
    }
}
