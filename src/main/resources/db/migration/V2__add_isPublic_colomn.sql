ALTER TABLE nour.course
    ADD COLUMN IF NOT EXISTS is_public boolean DEFAULT FALSE;