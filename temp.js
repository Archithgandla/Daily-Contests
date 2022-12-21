import mongoose from "mongoose";

const journalSchema = new mongoose.Schema({
    name : {type:String,required:true,trim:true},
    Domain : {type:String,required:true,trim:true},
    Year : {type : String,required:true,trim : true}
})

const journalModel = mongoose.model("journal",journalSchema);

