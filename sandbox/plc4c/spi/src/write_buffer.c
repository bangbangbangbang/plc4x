/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

#include <plc4c/spi/write_buffer.h>

uint8_t* plc4c_spi_write_get_data(plc4c_spi_write_buffer* buf) {
  return NULL;
}

uint32_t plc4c_spi_write_get_pos(plc4c_spi_write_buffer* buf) {
  return 0;
}

uint8_t* plc4c_spi_write_get_bytes(plc4c_spi_write_buffer* buf, uint32_t start_pos_in_bytes, uint32_t end_pos_in_bytes) {
  return NULL;
}

uint8_t plc4c_spi_write_peek_byte(plc4c_spi_write_buffer* buf, uint32_t offset_in_bytes) {
  return 0;
}

void plc4c_spi_write_bit(plc4c_spi_write_buffer* buf, bool value) {

}

// Unsigned Integers ...

void plc4c_spi_write_unsigned_byte(plc4c_spi_write_buffer* buf, uint8_t num_bits, uint8_t value) {

}

void plc4c_spi_write_unsigned_short(plc4c_spi_write_buffer* buf, uint8_t num_bits, uint16_t value) {

}

void plc4c_spi_write_unsigned_int(plc4c_spi_write_buffer* buf, uint8_t num_bits, uint32_t value) {

}

void plc4c_spi_write_unsigned_long(plc4c_spi_write_buffer* buf, uint8_t num_bits, uint64_t value) {

}

// TODO: Not sure which type to use in this case ...
/*void plc4c_spi_write_unsigned_big_integer(plc4c_spi_write_buffer* buf, uint8_t num_bits, uint128_t value) {
 * } */

// Signed Integers ...

void plc4c_spi_write_byte(plc4c_spi_write_buffer* buf, uint8_t num_bits, int8_t value) {

}

void plc4c_spi_write_short(plc4c_spi_write_buffer* buf, uint8_t num_bits, int16_t value) {

}

void plc4c_spi_write_int(plc4c_spi_write_buffer* buf, uint8_t num_bits, int32_t value) {

}

void plc4c_spi_write_long(plc4c_spi_write_buffer* buf, uint8_t num_bits, int64_t value) {

}

// TODO: Not sure which type to use in this case ...
/*void plc4c_spi_write_big_integer(plc4c_spi_write_buffer* buf, uint8_t num_bits, int128_t) {
 * } */

// Floating Point Numbers ...

void plc4c_spi_write_float(plc4c_spi_write_buffer* buf, uint8_t num_bits, float value) {

}

void plc4c_spi_write_double(plc4c_spi_write_buffer* buf, uint8_t num_bits, double value) {

}

// TODO: Not sure which type to use in this case ...
/*void plc4c_spi_write_big_decimal(plc4c_spi_write_buffer* buf, uint8_t num_bits, doubledouble value) {
 * } */

void plc4c_spi_write_string(plc4c_spi_write_buffer* buf, uint8_t num_bits, char* encoding, char* value) {

}
