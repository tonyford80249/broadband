package com.cdoe.util;

import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRPropertiesHolder;
import net.sf.jasperreports.engine.JRPropertiesMap;

/**
 *
 * @author Tony Ford
 */
public class JrDatasourceBasicField implements  JRField {
        private String name;
        private String description = "data field";
        private Class type;

        /**
         * 
         * @param name
         * @param type 
         */
        private JrDatasourceBasicField(String name, Class type) {
            this.name = name;
            this.type = type;
        }

        /**
         * 
         * @param name
         * @param description
         * @param type 
         */
        private JrDatasourceBasicField(String name, String description, Class type) {
            this.name = name;
            this.description = description;
            this.type = type;
        }
        
        /**
         * 
         * @param name
         * @param type
         * @return 
         */
        public static final JrDatasourceBasicField newInstance(String name, Class type) {
         return new JrDatasourceBasicField(name,type);
        }
        
        /**
         * 
         * @param name
         * @param description
         * @param type
         * @return 
         */
        public static final JrDatasourceBasicField newInstance(String name, String description, Class type) {
         return new JrDatasourceBasicField(name,description,type);   
        }
        
        /**
         * 
         * @return 
         */
        public String getName() {
           return name;
        }

        /**
         * 
         * @return 
         */
        public String getDescription() {
           return description;
        }

        /**
         * 
         * @param string 
         */
        public void setDescription(String string) {
            this.description = string;
        }

        /**
         * 
         * @return 
         */
        public Class getValueClass() {
            return type;
        }

        /**
         * 
         * @return 
         */
        public String getValueClassName() {
            return type.getName();
        }

        /**
         * 
         * @return 
         */
        public boolean hasProperties() {
            return false;
        }

        /**
         * 
         * @return 
         */
        public JRPropertiesMap getPropertiesMap() {
           return  new JRPropertiesMap();
        }

        /**
         * 
         * @return 
         */
        public JRPropertiesHolder getParentProperties() {
            return null;
        }

        /**
         * 
         * @return 
         */
        @Override
        public Object clone() {
          return this;
        } 
}
