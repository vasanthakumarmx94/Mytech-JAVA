import { Company } from "./Company";
import { Experience } from "./Experience";

export class Question {
    
    id: number;
    questionType:string;
    questionText:string;
    answerText:string;
    description:string;
    company:Company;
    experience:Experience;

    
    constructor() {
        
    }

}