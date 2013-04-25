package com.cdoe.rules.calc.data;;

public class RulesResponse {

	String comment;

	public String getComment() {
		return comment;
	}
	public void setComment(String s) {
		comment = s;
	}

	double ruleResult;
	/**
	 * @return
	 */
	public double getRuleResult() {
		return ruleResult;
	}

	/**
	 * @param strings
	 */
	public void setRuleResult(double strings) {
		ruleResult = strings;
	} 

	public String toString() {
		StringBuffer buf = new StringBuffer(2500);

		buf.append("The calculated Result obtained after applying the rules: ").append("\n");
		buf.append("\t").append(getRuleResult()).append("\n");
		if (comment != null)
			buf.append("Comment: ").append(comment).append("\n");

		if (getRuleResult() > 0 ) {
			System.out.println(buf.toString());
			//double roundedValue = Response.Round(getRuleResult(), 4);
			//System.out.println("Rules result after rounding is" + roundedValue);
			return buf.toString();
		}
		else 
			System.out.println("No rules matched the input data condition");
			return "No rules matched the input data condition";
	}
	
	public static double Round(double Rval, int Rpl) {
		   double p = (double)Math.pow(10,Rpl);
		   Rval = Rval * p;
		   float tmp = Math.round(Rval);
		   return (double)tmp/p;
	}

}
