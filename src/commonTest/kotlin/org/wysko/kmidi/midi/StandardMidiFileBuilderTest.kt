/*
 * Copyright © 2024 Jacob Wysko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wysko.kmidi.midi

import org.wysko.kmidi.midi.StandardMidiFile.Header.Format.Format1
import org.wysko.kmidi.midi.builder.smf
import kotlin.test.Test

class StandardMidiFileBuilderTest {
    @Test
    fun `Test build SMF`() {
        smf {
            division = tpq(96)
            format = Format1

            track {
                tempo(100)
            }

            track {
                channel(0) {
                    program(65)
                    note("D4", 1.eighth)
                    note("E4", 1.eighth)
                    note("F4", 1.eighth)
                    note("G4", 1.eighth)
                    note("E4", 1.quarter)
                    note("C4", 1.eighth)
                    note("D4", 1.eighth + 1.half)
                }
            }
        }
    }
}
