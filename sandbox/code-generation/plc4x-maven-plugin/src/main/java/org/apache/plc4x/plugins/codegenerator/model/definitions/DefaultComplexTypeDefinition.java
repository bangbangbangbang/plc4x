/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package org.apache.plc4x.plugins.codegenerator.model.definitions;

import org.apache.plc4x.language.fields.ConstField;
import org.apache.plc4x.language.fields.Field;
import org.apache.plc4x.language.definitions.ComplexTypeDefinition;
import org.apache.plc4x.language.fields.SimpleField;
import org.apache.plc4x.plugins.codegenerator.model.fields.DefaultConstField;
import org.apache.plc4x.plugins.codegenerator.model.fields.DefaultSimpleField;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultComplexTypeDefinition extends DefaultTypeDefinition implements ComplexTypeDefinition {

    private final boolean isAbstract;
    private final List<Field> fields;

    public DefaultComplexTypeDefinition(String name, boolean isAbstract, List<Field> fields) {
        super(name);
        this.isAbstract = isAbstract;
        this.fields = fields;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public List<Field> getFields() {
        return fields;
    }

    @Override
    public List<SimpleField> getSimpleFields() {
        return fields.stream().filter(field -> field instanceof DefaultSimpleField).map(
            field -> (DefaultSimpleField) field).collect(Collectors.toList());
    }

    @Override
    public List<ConstField> getConstFields() {
        return fields.stream().filter(field -> field instanceof DefaultConstField).map(
            field -> (DefaultConstField) field).collect(Collectors.toList());
    }

    @Override
    public List<SimpleField> getAllSimpleFields() {
        List<SimpleField> fields = new LinkedList<>();
        if(getParentType() != null) {
            fields.addAll(((ComplexTypeDefinition)getParentType()).getAllSimpleFields());
        }
        fields.addAll(getSimpleFields());
        return fields;
    }

    @Override
    public List<SimpleField> getParentSimpleFields() {
        if(getParentType() != null) {
            return ((ComplexTypeDefinition)getParentType()).getAllSimpleFields();
        }
        return Collections.emptyList();
    }

}